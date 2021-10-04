package scripts;

import generics.Excel;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;
import pom.LoginPage;

import java.io.IOException;

public class BlankLogin extends BaseTest {
    @Test
    public void testBlankLogin() throws IOException {
        String xlPath = "./TestData/TDR.xlsx";
        String sheet = "BlankLogin";
        String un = Excel.getCellData(xlPath, sheet, 1, 0);
        String pw = Excel.getCellData(xlPath, sheet, 1, 1);
        LoginPage l = new LoginPage(driver);
        l.setUserName(un);
        l.setPassword(pw);
        l.clickLoginButton();
        l.verifyErrMsg1();
        l.verifyErrMsg2();
        try {
            Assert.assertEquals(driver.getCurrentUrl(), "http://stock.scriptinglogic.net/",
                    "this is not a correct page");
        } catch (AssertionError e) {
            Reporter.log(e.getMessage(), true);
            scripts.ScreenShot.takeScreenShot(driver);
        }
    }
}
