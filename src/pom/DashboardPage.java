package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DashboardPage {

    @FindBy(linkText = "Add Sales")
    private WebElement lnkAddSales;

    @FindBy(linkText = "Add Purchase")
    private WebElement lnkAddPurchase;

    @FindBy(linkText = "Add Supplier")
    private WebElement lnkAddSupplier;

    @FindBy(linkText = "Add Customer")
    private WebElement lnkAddCustomer;

    @FindBy(linkText = "Report")
    private WebElement lnkReport;

    public DashboardPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void clickAddSales() {
        lnkAddSales.click();
    }

    public void clickAddPurchase() {
        lnkAddPurchase.click();
    }

    public void clickAddSupplier() {
        lnkAddSupplier.click();
    }

    public void clickAddCustomer() {
        lnkAddCustomer.click();
    }

    public void clickReport() {
        lnkReport.click();
    }
}
