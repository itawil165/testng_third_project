package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class CarvanaSearchPage {

    public CarvanaSearchPage (WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "[data-qa='label-text']")
    public List<WebElement> filterOptions;

    @FindBy(css = "[data-qa='search-bar-input']")
    public WebElement carSearchInputBox;

    @FindBy(css = ".result-tile")
    public List<WebElement> tiles;

    @FindBy(css = "div.favorite-vehicle")
    public List<WebElement> tileAddToFavoritesButtons;

    @FindBy(css = ".result-tile img")
    public List<WebElement> tileImages;

    @FindBy(css = "div.inventory-type-variant")
    public List<WebElement> tileInventoryTypes;

    @FindBy(css = "div.make-model")
    public List<WebElement> tileMakeModelAndYears;

    @FindBy(css = "div.trim-mileage")
    public List<WebElement> tileTrimAndMileages;

    @FindBy(css = "div.price")
    public List<WebElement> tilePrices;

    @FindBy(css = "div.monthly-payment")
    public List<WebElement> tileMonthlyPayments;

    @FindBy(css = "div.down-payment")
    public List<WebElement> tileDownPayments;

    @FindBy(css = "span.delivery")
    public List<WebElement> tileDeliveryChips;
}
