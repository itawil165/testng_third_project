package scripts;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.Waiter;

public class CarvanaTest extends Base {

    @Test(priority = 1)
    public void testCarvanaTitleAndUrl() {

        driver.get("https://www.carvana.com/");

        Assert.assertEquals(driver.getTitle(), "Carvana | Buy & Finance Used Cars Online | At Home Delivery");
        Assert.assertEquals(driver.getCurrentUrl(), "https://www.carvana.com/");
    }

    @Test(priority = 2)
    public void testCarvanaLogo() {

        driver.get("https://www.carvana.com/");

        Assert.assertTrue(carvanaHomePage.logo.isDisplayed());
    }

    @Test(priority = 3)
    public void testCarvanaNavigation() {

         driver.get("https://www.carvana.com/");

        String[] navigationSectionsText = {"HOW IT WORKS", "ABOUT CARVANA", "SUPPORT & CONTACT"};

        for (int i = 0; i < 3; i++) {
            Assert.assertEquals(carvanaHomePage.navigationSections.get(i).getText(), navigationSectionsText[i]);
        }
    }

    @Test(priority = 4)
    public void testSignInErrorMessage() {

        driver.get("https://www.carvana.com/");

        carvanaHomePage.signInLink.click();

        carvanaHomePage.emailInputBox.sendKeys("johndoe@gmail.com");
        carvanaHomePage.passwordInputBox.sendKeys("abcd1234");
        carvanaHomePage.signInButton.click();

        Waiter.pause(1);

        Assert.assertEquals(carvanaHomePage.errorMessage.getText(), "Email address and/or password combination is incorrect\n" +
                "Please try again or reset your password.");
    }

    @Test(priority = 5)
    public void testCarSearchFilters() {

        driver.get("https://www.carvana.com/");

        carvanaHomePage.searchCarsLink.click();
        Waiter.pause(1);

        Assert.assertEquals(driver.getCurrentUrl(), "https://www.carvana.com/cars");

        String[] filterOptionsText = {"PAYMENT & PRICE", "MAKE & MODEL", "BODY TYPE", "YEAR & MILEAGE", "FEATURES", "MORE FILTERS"};
        for (int i = 0; i < 6; i++) {
            Assert.assertEquals(carvanaSearchPage.filterOptions.get(i).getText(), filterOptionsText[i]);
        }
    }

    @Test(priority = 6)
    public void testCarSearchResults() {

        driver.get("https://www.carvana.com/");

        carvanaHomePage.searchCarsLink.click();
        Waiter.pause(1);

        Assert.assertEquals(driver.getCurrentUrl(), "https://www.carvana.com/cars");

        carvanaSearchPage.carSearchInputBox.sendKeys("mercedes benz" + Keys.ENTER);
        Waiter.pause(2);

        Assert.assertTrue(driver.getCurrentUrl().contains("mercedes-benz"));

        for (int i = 0; i < carvanaSearchPage.tiles.size(); i++) {
            Assert.assertTrue(carvanaSearchPage.tiles.get(i).isDisplayed());
            Assert.assertTrue(carvanaSearchPage.tileImages.get(i).isDisplayed());
            Assert.assertTrue(carvanaSearchPage.tileAddToFavoritesButtons.get(i).isDisplayed());
            Assert.assertTrue(carvanaSearchPage.tileInventoryTypes.get(i).isDisplayed());
            Assert.assertNotNull(carvanaSearchPage.tileInventoryTypes.get(i).getText());
            Assert.assertTrue(carvanaSearchPage.tileMakeModelAndYears.get(i).isDisplayed());
            Assert.assertNotNull(carvanaSearchPage.tileMakeModelAndYears.get(i).getText());
            Assert.assertTrue(carvanaSearchPage.tileTrimAndMileages.get(i).isDisplayed());
            Assert.assertNotNull(carvanaSearchPage.tileTrimAndMileages.get(i).getText());
            Assert.assertTrue(carvanaSearchPage.tilePrices.get(i).isDisplayed());
            Assert.assertTrue(Integer.parseInt(carvanaSearchPage.tilePrices.get(i).getText().replaceAll("[^0-9]", "")) > 0);
            Assert.assertTrue(carvanaSearchPage.tileMonthlyPayments.get(i).isDisplayed());
            Assert.assertNotNull(carvanaSearchPage.tileMonthlyPayments.get(i).getText());
            Assert.assertTrue(carvanaSearchPage.tileDownPayments.get(i).isDisplayed());
            Assert.assertNotNull(carvanaSearchPage.tileDownPayments.get(i).getText());
            Assert.assertTrue(carvanaSearchPage.tileDeliveryChips.get(i).isDisplayed());
            Assert.assertNotNull(carvanaSearchPage.tileDeliveryChips.get(i).getText());
        }

    }
}
