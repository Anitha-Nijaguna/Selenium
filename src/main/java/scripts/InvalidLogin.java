package scripts;

import generics.Excel;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;
import pom.LoginPage;

import java.io.IOException;

public class InvalidLogin extends BaseTest{
    @Test
    public void testInvalidLogin() throws IOException, InterruptedException {
        String xlPath ="./TestData/TDR.xlsx";
        String sheet = "InvalidLogin";
        int rc = Excel.getRowCount(xlPath,sheet);
        for(int i=1; i<=rc; i++) {
            String un = Excel.getCellData(xlPath, sheet, i, 0);
            String pw = Excel.getCellData(xlPath, sheet, i, 1);
            LoginPage l = new LoginPage(driver);
            l.setUserName(un);
            l.setPassword(pw);
            l.clickLoginButton();
            Thread.sleep(1000);
            l.verifyErrMsg();
            try {
                Assert.assertEquals(driver.getCurrentUrl(), "http://stock.scriptinglogic.net/index.php?msg=Wrong%20Username%20or%20Password&type=error",
                        "this is not a correct page");
                Reporter.log("Invalid Login Successful - Test passed", true);
            } catch (AssertionError e) {
                Reporter.log(e.getMessage(), true);
                ScreenShot.takeScreenShot(driver);
            }
        }
    }
}
