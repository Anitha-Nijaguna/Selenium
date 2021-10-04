import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

import static io.github.bonigarcia.wdm.WebDriverManager.*;

public class SeleniumDemo {
    public static void main(String[] args) {

        //open browser (chrome)
        chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        // maximize
        driver.manage().window().maximize();

        //implicit wait
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        //open url
        driver.get("http://gmail.com");

        System.out.println(driver.getTitle());
        System.out.println(driver.getCurrentUrl());

        //close browser
        driver.close();

    }
}
