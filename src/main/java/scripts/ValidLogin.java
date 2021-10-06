package scripts;

import generics.Excel;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;
import pom.LoginPage;

import java.io.IOException;

public class ValidLogin extends BaseTest {
    @Test
    public void testValidLogin() throws IOException {
        String xlPath = "./TestData/TDR.xlsx";
        String sheet = "ValidLogin";
        String un = Excel.getCellData(xlPath, sheet, 1, 0);
        String pw = Excel.getCellData(xlPath, sheet, 1, 1);
        LoginPage l = new LoginPage(driver);
        l.setUserName(un);
        l.setPassword(pw);
        l.clickLoginButton();
        try {
            Assert.assertEquals(driver.getCurrentUrl(), "http://stock.scriptinglogic.net/dashboard.php",
                    "this is not Dashboard page");
            Reporter.log("Valid Login Successful - Test passed", true);
        } catch (AssertionError e) {
            Reporter.log(e.getMessage(), true);
            ScreenShot.takeScreenShot(driver);
        }
    }
}