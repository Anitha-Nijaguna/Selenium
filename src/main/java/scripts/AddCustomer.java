package scripts;

import generics.Excel;
import org.testng.annotations.Test;
import pom.AddCustomerPage;
import pom.DashboardPage;
import pom.LoginPage;

public class AddCustomer extends BaseTest{
    @Test
    public void testAddCustomer () {
        String xlPath = "./TestData/TDR.xlsx";
        String sheet = "ValidLogin";
        String un = Excel.getCellData(xlPath, sheet, 1, 0);
        String pw = Excel.getCellData(xlPath, sheet, 1, 1);
        LoginPage l = new LoginPage(driver);
        l.setUserName(un);
        l.setPassword(pw);
        l.clickLoginButton();

        DashboardPage d = new DashboardPage(driver);
        d.clickAddCustomer();

        sheet = "AddCustomer";
        int rc = Excel.getRowCount(xlPath,sheet);
        for(int i=1; i<=rc; i++) {
            String name = Excel.getCellData(xlPath, sheet, i, 0);
            String address = Excel.getCellData(xlPath, sheet, i, 1);
            String ct1 = Excel.getCellData(xlPath, sheet, i, 2);
            String ct2 = Excel.getCellData(xlPath, sheet, i, 3);
            AddCustomerPage ac = new AddCustomerPage(driver);
            ac.setName(name);
            ac.setAddress(address);
            ac.setContact1(ct1);
            ac.setContact2(ct2);
            ac.clickAddButton();
            ac.verifyMsg();
        }
    }
}


