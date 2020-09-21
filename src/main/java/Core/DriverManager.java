package Core;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class DriverManager {

    private WebDriver driver;
    private static DriverManager driverManager = new DriverManager();

    private DriverManager(){
    }

    public static DriverManager getInstance(){
        return driverManager;
    }

    public void invokeChromeDriver(){
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    public WebDriver getDriver(){
        return driver;
    }

}
