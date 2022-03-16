package com.hrm.qa.pages;

import com.hrm.qa.base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class AdminPage extends TestBase {

    @FindBy(xpath = "//b[contains(text(),'Admin')]")
    WebElement adminLabel;

    @FindBy(id = "systemUser_employeeName_empName")
    WebElement employeeName;

    @FindBy(id = "systemUser_userName")
    WebElement username;

    @FindBy(id = "systemUser_password")
    WebElement password;

    @FindBy(id = "systemUser_confirmPassword")
    WebElement confirmPassword;

    @FindBy(xpath = "//input[@id='btnSave']")
    WebElement saveButton;

    @FindBy(xpath = "//input[@id='btnAdd']")
    WebElement addButton;

    public AdminPage() {
        PageFactory.initElements(driver, this);
    }

    public boolean verifyAdminLabel() {
        return adminLabel.isDisplayed();
    }

    public void selectUsersByName(String name) {
        driver.findElement(By.xpath(" //a[text()='" + name + "']//parent::td[@class='left']//preceding-sibling::td//input[@name='chkSelectRow[]']")).click();
    }

    public void clickOnAddButton() {
        addButton.click();
    }

    public void createNewAdminUser(String employName, String userNam, String pass, String confirPass) {
        Select select = new Select(driver.findElement(By.id("systemUser_userType")));
        select.selectByVisibleText("Admin");
        employeeName.sendKeys(employName);
        username.sendKeys(userNam);
        password.sendKeys(pass);
        confirmPassword.sendKeys(confirPass);
        saveButton.click();

    }

    public void createNewUser(String name, String user, String pass, String confirmPass) {
        employeeName.sendKeys(name);
        username.sendKeys(user);
        password.sendKeys(pass);
        confirmPassword.sendKeys(confirmPass);
        saveButton.click();


    }


}
