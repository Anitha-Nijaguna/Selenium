package scripts;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.IOException;

public class ExtentReport {
    ExtentReports extent;

    @BeforeClass
    public void init() {
        ExtentSparkReporter reporter = new ExtentSparkReporter("Reports\\report.html");
        reporter.config().setDocumentTitle("My Project Name");
        reporter.config().setReportName("All Regression Tests");

        extent = new ExtentReports();
        extent.attachReporter(reporter);

        extent.setSystemInfo("Company Name", "Scripting Logic");
        extent.setSystemInfo("Project Name", "HRM");
        extent.setSystemInfo("Testers Name", "Anitha Nijaguna");
        extent.setSystemInfo("Test Lead", "Ramesh");
    }

    @Test
    public void myTest1() {
        ExtentTest test = extent.createTest("scriptingOpen");

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        test.info("browser is opened");

        driver.manage().window().maximize();
        test.info("browser is maximised");

        driver.get("http://scriptinglogic.com");
        test.info("scripting logic is opened");

        try {
            Assert.assertEquals(driver.getTitle(), "Scripting Logic – Tutorials website",
                    "This is not a scripting logic website");
            test.pass("we are on scripting logic");
        } catch (AssertionError e) {
            test.fail(e.getMessage());
        }
        extent.flush();
    }

    @Test
    public void myTest2() throws IOException {
        ExtentTest test = extent.createTest("facebookOpen");

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        test.info("browser is opened");

        driver.manage().window().maximize();
        test.info("browser is maximised");

        driver.get("http://facebook.com");
        test.info("facebook is opened");

        try {
            Assert.assertEquals(driver.getTitle(), "Facebook - Log in or Sign Up",
                    "This is not a facebook website");
            test.pass("we are on facebook");
        } catch (AssertionError e) {
            test.fail(e.getMessage());
            test.addScreenCaptureFromPath("./screenshots/"+ ScreenShot.takeScreenShot(driver));
        }
        extent.flush();
    }

    @Test
    public void myTest3() {
        ExtentTest test = extent.createTest("gmailOpen");

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        test.info("gmail is opened");

        driver.manage().window().maximize();
        test.info("browser is maximised");

        driver.get("http://gmail.com");
        test.info("url is opened");

        try {
            Assert.assertEquals(driver.getTitle(), "Gmail",
                    "This is not a gmail website");
            test.pass("we are on gmail");
        } catch (AssertionError e) {
            test.fail(e.getMessage());
        }
        extent.flush();
    }
}
