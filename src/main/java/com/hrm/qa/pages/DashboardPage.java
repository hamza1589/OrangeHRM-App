package com.hrm.qa.pages;

import com.hrm.qa.base.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DashboardPage extends TestBase {
    @FindBy(xpath = "//a[contains(text(),'Welcome Sandhya')]")
    WebElement userLabel;

    @FindBy(xpath = "//div[@class='head']/h1")
    WebElement dashboardText;

    @FindBy(xpath = "//a[@id='menu_pim_viewMyDetails']")
    WebElement myInfoLink;

    @FindBy(xpath = "//a[@id='menu_admin_viewAdminModule']")
    WebElement adminLink;

    @FindBy(xpath = "//a[text()='User Management']")
    WebElement userManagementLink;

    public DashboardPage() {
        PageFactory.initElements(driver, this);
    }

    public boolean verifyCorrectUserName() {
        return userLabel.isDisplayed();
    }

    public String verifyHomePageTitle() {
        return driver.getTitle();
    }

    public boolean verifyDashboardHeaderIsDisplayed() {
        return dashboardText.isDisplayed();

    }

    public AdminPage clickOnAdminLink() {
        adminLink.click();
        return new AdminPage();
    }

    public MyInfoPage clickOnMyInfoLink() {
        myInfoLink.click();
        return new MyInfoPage();
    }

    public void clickOnUserManagementLink() {
        Actions actions = new Actions(driver);
        actions.moveToElement(adminLink).build().perform();
        userManagementLink.click();

    }


}
