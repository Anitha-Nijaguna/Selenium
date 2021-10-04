package scripts;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ScreenShot {
    public static String takeScreenShot(WebDriver driver) throws IOException {
        TakesScreenshot ts = (TakesScreenshot) driver;

        File scrFile = ts.getScreenshotAs(OutputType.FILE);

        String timeStamp = new SimpleDateFormat("_ddMMyyyy_hh_mm_ss")
                .format(new Date());

        String image = "image"+timeStamp+".png";

        // 3. create a real image file
        FileUtils.copyFile(scrFile,new File("Reports\\screenshots\\"+image) );
        return image;
    }
}
