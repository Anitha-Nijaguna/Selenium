package generics;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


public class ExcelDataProvider {
    WebDriver driver;
    @BeforeTest
    public void setUp()
    {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://opensource-demo.orangehrmlive.com/");
    }
    @Test(dataProvider = "test1data")
    public void test1(String username, String password) throws InterruptedException {
        System.out.println(username +" | "+password);
        driver.findElement(By.id("txtUsername")).sendKeys(username);
        driver.findElement(By.id("txtPassword")).sendKeys(password);
        Thread.sleep(2000);
    }

    @DataProvider(name = "test1data")
    public Object[][] getData() {
        String projectPath = System.getProperty("user.dir");
        String excelPath = projectPath+"/TestData/TDR.xlsx";
        Object data[][] = testData(excelPath, "OrangeHRM");
        return data;
    }

        public Object[][] testData(String excelPath, String sheetName) {
        ExcelUtils excel = new ExcelUtils(excelPath, sheetName);
        int rowCount = excel.getRowCount();
        int colCount = excel.getColCount();

        Object data[][] = new Object[rowCount-1][colCount];
        for (int i=1; i<rowCount; i++) {
            for (int j=0; j<colCount; j++) {
              String cellData = excel.getCellData(i,j);
              data[i-1][j] = cellData;
            }
        }
        return data;
    }
}
