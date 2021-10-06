package scripts;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.xml.XmlTest;

import java.util.concurrent.TimeUnit;

public class BaseTest {
    public WebDriver driver;

    @BeforeMethod
    public void preCondition(XmlTest x) {
        String browser = x.getParameter("browser");
        Reporter.log("Browser is:" + browser, true);
        if (browser.equals("GC")) {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        } else if (browser.equals("FF")) {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
        }
        driver.manage().window().maximize();

        driver.get("http://stock.scriptinglogic.net/");
        Reporter.log("Scripting Logic page opened", true);

        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    }

    @AfterMethod
    public void postCondition() {
        driver.close();
    }
}
