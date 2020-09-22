package Core;

import static Core.GlobalData.API_KEY;
import static Core.GlobalData.API_URL;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.JSONObject;

public class APITest {

    private static String getHostName(){
        return "https://" + API_URL;
    }

    public static Response getTempAPI(String cityName){
        JSONObject queryParams = new JSONObject();
        queryParams.put("q", cityName);
        queryParams.put("appid", API_KEY);

        RequestSpecification requestSpecification = RestAssured.given();
        requestSpecification.queryParams(queryParams.toMap());
        System.out.println("RESPONSE:######################:" + requestSpecification.get(getHostName()).getBody().prettyPrint());
        return requestSpecification.get(getHostName());

    }

    public static int getTempDetails(Response response){
        JSONObject responseBody = new JSONObject(response.getBody().prettyPrint());
        JSONObject tempObj = responseBody.getJSONObject("main");
        System.out.println("TEMP VALUE:############" + tempObj.getNumber("temp").intValue());
        return tempObj.getNumber("temp").intValue();
    }

}
