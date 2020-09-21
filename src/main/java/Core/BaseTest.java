package Core;

import Pages.NDTVHomePage;
import Pages.NDTVWeatherPage;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

public class BaseTest {

    protected NDTVHomePage homePage;
    protected NDTVWeatherPage weatherPage;

    @BeforeSuite
    public void initialiseSuite(){
        DriverManager.getInstance().invokeChromeDriver();
    }

    @BeforeClass
    public void initialiseObjects(){
        homePage = new NDTVHomePage();
        weatherPage = new NDTVWeatherPage();
    }

}
