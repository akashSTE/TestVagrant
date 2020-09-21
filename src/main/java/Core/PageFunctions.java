package Core;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;

public class PageFunctions {
    private final WebDriver driver;
    private WebDriverWait wait;
    private int IMPLICIT_WAIT_TIME;

    public PageFunctions() {
        this.driver = DriverManager.getInstance().getDriver();
        int EXPLICI_WAIT_TTIME = 30;
        wait = new WebDriverWait(driver, EXPLICI_WAIT_TTIME);
    }

    public void navigateToURL(String url) {
        driver.get(url);
    }

    protected void waitForElement(By loc){
        wait.until(ExpectedConditions.visibilityOfElementLocated(loc));
    }

    protected void clickOnLocator(By loc) {
        try {
            waitForElement(loc);
            driver.findElement(loc).click();
        } catch (Exception e) {
            e.printStackTrace();
            try {
                driver.navigate().refresh();
                waitForElement(loc);
                driver.findElement(loc).click();
            } catch (Exception eh) {
                eh.printStackTrace();
            }
        }
        waitForElement(By.xpath("//*"));
    }

    public String getPageTitle(){
        return driver.getTitle();
    }

    protected void sendKeys(By by, String stringText) {
        WebElement webelement;
        try {
            webelement=waitForVisibilityOfElement(by);
            webelement.click();
            webelement.clear();
            webelement.sendKeys(stringText);
        } catch (StaleElementReferenceException se) {
            webelement=waitForVisibilityOfElement(by);
            webelement.click();
            webelement.clear();
            webelement.sendKeys(stringText);
        } catch (Exception e) {
            Assert.fail(e.getMessage());
        }
    }

    protected WebElement waitForVisibilityOfElement(By locator) {
        WebElement element;
        try {
            element=wait.until(ExpectedConditions.presenceOfElementLocated(locator));
            element=wait.until(ExpectedConditions.visibilityOf(element));
        } catch (TimeoutException | NoSuchElementException se) {
            try {
                element=wait.until(ExpectedConditions.presenceOfElementLocated(locator));
            } catch (Exception e) {
                element=null;
                Assert.fail(e.getMessage());
            }
        }
        return element;
    }

/*    protected ArrayList<WebElement> findElements(By loc){
        ArrayList<WebElement> elements = new ArrayList<WebElement>();
        elements = (ArrayList<WebElement>) driver.findElements(loc);
        return elements;
    }*/

    protected By parameterizedText(String loc, String... txt){
        return By.xpath(MessageFormat.format(loc,txt));
    }

    protected boolean isDisplayed(By by) {
        boolean flag = true;
        try {
            IMPLICIT_WAIT_TIME=1;
            waitForVisibilityOfElement(by);
            try {
                waitForVisibilityOfElement(by);
                if (!driver.findElement(by).isDisplayed()) {
                    flag = false;
                }
            } catch (StaleElementReferenceException e) {
                waitForVisibilityOfElement(by);
                if (!driver.findElement(by).isDisplayed()) {
                    flag = false;
                }
            } catch (Exception e) {
                flag = false;
            }
            return flag;
        } catch (TimeoutException te) {
            Reporter.log("Element is not displayed");
            return false;
        } finally {
            IMPLICIT_WAIT_TIME =30;
        }
    }

    public void hardWait(int seconds) {
        try {
            Thread.sleep(seconds * 1000);
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
    }

}
