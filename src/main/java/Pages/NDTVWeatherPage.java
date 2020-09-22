package Pages;

import Core.PageFunctions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.ArrayList;

public class NDTVWeatherPage extends PageFunctions {

    private By searchBox = By.xpath("//input[@id='searchBox']");
    private String selectCity = "//label[contains(text(),''{0}'')]";
    private String cityOnMap = "//div[contains(text(),''{0}'')]";
    private String cityOnMapTempInC = "//div[@title=''{0}'']//div//span[@class=''tempRedText'']";
    private String cityOnMapTempInF = "//div[@title=''{0}'']//div//span[@class=''tempWhiteText'']";
    private By mapCanvas = By.xpath("//div[@id='map_canvas']");
    private String cityOnMapWeatherDetails = "//span[contains(text(),''{0}'')]/../..//b[contains(text(),''Condition'') or contains(text(),''Wind'')]";

    public boolean selectCity(String cityName){
        clickOnLocator(parameterizedText(selectCity, cityName));
        return isDisplayed(parameterizedText(cityOnMap, cityName));
    }

    public boolean isCityOnMapTempInCelDisplayed(String cityName){
        return isDisplayed(parameterizedText(cityOnMapTempInC, cityName));
    }

    public String getCityOnMapTempInC(String cityName){
        return getText(parameterizedText(cityOnMapTempInC, cityName));
    }

    public String removeDegreeCelsius(String str){
        int i =  str.indexOf("℃");
        return str.substring(0,i);
    }

    public boolean isCityOnMapTempInFehDisplayed(String cityName){
        return isDisplayed(parameterizedText(cityOnMapTempInF, cityName));
    }

    public boolean isMapCanvasPresent(){
        hardWait(8);
        return isDisplayed(mapCanvas);
    }

    public boolean isCityOnMapWeatherDetailsDisplayed(String cityName){
        waitForVisibilityOfElement(parameterizedText(cityOnMap, cityName));
        clickOnLocator(parameterizedText(cityOnMap, cityName));
        return isDisplayed(parameterizedText(cityOnMapWeatherDetails, cityName));
    }



}
