import Core.BaseTest;
import Core.GlobalData;
import org.testng.Assert;
import org.testng.annotations.Test;

import static Core.GlobalData.*;

public class Phase1 extends BaseTest {

    @Test(priority = 1)
    public void openNDTVWebPage() {
        homePage.navigateToURL(GlobalData.URL);
        homePage.clickOnNoThanksButton();
        Assert.assertEquals(homePage.getPageTitle(), "NDTV: Latest News, India News, Breaking News, Business, Bollywood, Cricket, Videos & Photos");
    }

    @Test(priority = 2)
    public void openWeatherPage() {
        homePage.clickOnSubMenuButton();
        homePage.clickOnWeatherButton();
        weatherPage.isMapCanvasPresent();
        Assert.assertEquals(homePage.getPageTitle(), "NDTV Weather - Weather in your Indian City");
    }

    @Test(priority = 3)
    public void pinCityOnMap() {
        Assert.assertTrue(weatherPage.selectCity(CITY_NAME));
    }

    @Test(priority = 4)
    public void cityOnMapTempInCel() {
        Assert.assertTrue(weatherPage.isCityOnMapTempInCelDisplayed(CITY_NAME));
        String tempInC = weatherPage.getCityOnMapTempInC(CITY_NAME);
        tempInC = weatherPage.removeDegreeCelsius(tempInC);
        tempFromUI =  Integer.parseInt(tempInC);
        System.out.println("############: "+tempFromUI);
    }

    @Test(priority = 5)
    public void cityOnMapTempInFeh() {
        Assert.assertTrue(weatherPage.isCityOnMapTempInFehDisplayed(CITY_NAME));
    }

    @Test(priority = 6)
    public void weatherDetailsAfterClickCityOnMap() {
        weatherPage.hardWait(3);
        Assert.assertTrue(weatherPage.isCityOnMapWeatherDetailsDisplayed(CITY_WEATHER_DETAILS_ON_MAP));
    }

}
