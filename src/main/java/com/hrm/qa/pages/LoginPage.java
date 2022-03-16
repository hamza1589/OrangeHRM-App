package com.hrm.qa.pages;

import com.hrm.qa.base.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends TestBase {
    @FindBy(id = "txtUsername")
    WebElement username;

    @FindBy(id = "txtPassword")
    WebElement password;

    @FindBy(xpath = "//input[@id='btnLogin']")
    WebElement loginBtn;

    @FindBy(xpath = "//div/div[@id='divLogo']/img")
    WebElement hrmLogo;

    public LoginPage() {
        PageFactory.initElements(driver, this);
    }

    public String validateLoginPageTitle() {
        return driver.getTitle();
    }

    public boolean validateHRMImage() {
        return hrmLogo.isDisplayed();
    }

    public DashboardPage login(String un, String pwd) {
        username.sendKeys(un);
        password.sendKeys(pwd);
        loginBtn.click();
        return new DashboardPage();

    }

}
