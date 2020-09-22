package Pages;


import Core.PageFunctions;
import org.openqa.selenium.By;

public class NDTVHomePage extends PageFunctions {

    private By subMenuButton = By.xpath("//a[@id='h_sub_menu']");
    private By weatherButton = By.xpath("//a[contains(text(),'WEATHER')]");
    private By noThanksPopUpButton = By.xpath("//a[contains(text(),'No Thanks')]");

    public void clickOnSubMenuButton() {
        clickOnLocator(subMenuButton);
    }

    public void clickOnWeatherButton() {
        clickOnLocator(weatherButton);
    }

    public void clickOnNoThanksButton() {
        clickOnLocator(noThanksPopUpButton);
    }

}
