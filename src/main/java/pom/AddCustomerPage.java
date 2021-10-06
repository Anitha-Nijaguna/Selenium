package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.Reporter;

public class AddCustomerPage {
    @FindBy(name= "name")
    private WebElement txtName;

    @FindBy(name= "address")
    private WebElement txtAddress;

    @FindBy(name= "contact1")
    private WebElement txtContact1;

    @FindBy(name= "contact2")
    private WebElement txtContact2;

    @FindBy(name= "Submit")
    private WebElement btnAdd;

    @FindBy(xpath = "/html[1]/body[1]/div[3]/div[1]/div[2]/div[1]/div[2]/div[1]")
    private WebElement msg;

    public AddCustomerPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void setName(String name) {
        txtName.sendKeys(name);
    }

    public void setAddress(String address) {
        txtAddress.sendKeys(address);
    }

    public void setContact1(String ct1) {
        txtContact1.sendKeys(ct1);
    }

    public void setContact2(String ct2) {
        txtContact2.sendKeys(ct2);
    }

    public void clickAddButton() {
        btnAdd.click();
    }

    public void verifyMsg() {
        Assert.assertTrue(msg.isDisplayed(), "Msg not displayed.");
        Reporter.log(msg.getText(), true );
    }
}
