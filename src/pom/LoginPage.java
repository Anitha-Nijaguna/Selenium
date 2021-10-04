package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.Reporter;

public class LoginPage {
    @FindBy(id = "login-username")
    private WebElement unTextBox;

    @FindBy(id = "login-password")
    private WebElement pwTextBox;

    @FindBy(name = "submit")
    private WebElement btnSubmit;

    @FindBy(xpath = "/html[1]/body[1]/div[3]/form[1]/fieldset[1]/div[1]")
    private WebElement errMsg;

    @FindBy(xpath = "/html[1]/body[1]/div[3]/form[1]/fieldset[1]/p[2]/label[2]")
    private WebElement errMsg1;

    @FindBy(xpath = "/html[1]/body[1]/div[3]/form[1]/fieldset[1]/p[3]/label[2]")
    private WebElement errMsg2;

    public LoginPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void setUserName(String un) {
        unTextBox.sendKeys(un);
    }

    public void setPassword(String pw) {
        pwTextBox.sendKeys(pw);
    }

    public void clickLoginButton() {
        btnSubmit.click();
    }

    public void verifyErrMsg() {
        Assert.assertTrue(errMsg.isDisplayed(), "Error msg not displayed.");
        Reporter.log(errMsg.getText(), true);
    }

    public void verifyErrMsg1() {
        Assert.assertTrue(errMsg1.isDisplayed(), "Error msg not displayed.");
        Reporter.log(errMsg1.getText());
    }

    public void verifyErrMsg2() {
        Assert.assertTrue(errMsg2.isDisplayed(), "Error msg not displayed.");
        Reporter.log(errMsg2.getText());
    }
}