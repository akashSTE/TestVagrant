package Core;

import Pages.NDTVHomePage;
import Pages.NDTVWeatherPage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

public class BaseTest {

    protected NDTVHomePage homePage;
    protected NDTVWeatherPage weatherPage;
    protected Comparator comparator;
    protected PageFunctions pageFunctions;

    @BeforeSuite
    public void initialiseSuite(){
        DriverManager.getInstance().invokeChromeDriver();
    }

    @BeforeClass
    public void initialiseObjects(){
        homePage = new NDTVHomePage();
        weatherPage = new NDTVWeatherPage();
        comparator = new Comparator();
        pageFunctions = new PageFunctions();
    }

    @AfterSuite
    public void closeBrowser(){
        pageFunctions.closeBrowserWindow();
    }

}
