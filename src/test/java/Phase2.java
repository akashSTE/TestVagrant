import Core.BaseTest;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import static Core.APITest.getTempAPI;
import static Core.APITest.getTempDetails;
import static Core.GlobalData.CITY_NAME;
import static Core.GlobalData.tempFromAPI;

public class Phase2 extends BaseTest {

    Response response;

    @Test(priority = 1)
    public void hitWeatherAPI() {
        response = getTempAPI(CITY_NAME);
        Reporter.log(response.getBody().prettyPrint());
        System.out.println("STATUS CODE:############" + response.getStatusCode());
        Assert.assertEquals(response.getStatusCode(), 200);
    }

    @Test(priority = 2)
    public void getWeatherTemperature() {
        int temp = getTempDetails(response);
        Reporter.log(CITY_NAME + " Temp return: " + temp);
        tempFromAPI = temp;
        System.out.println("Temp from API: "+tempFromAPI);
    }
}



