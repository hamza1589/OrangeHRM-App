package com.hrm.qa.pages;

import com.hrm.qa.base.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyInfoPage extends TestBase {
    @FindBy(xpath = "//b[contains(text(),'My Info')]")
    WebElement myInfoLink;
    @FindBy(xpath = "//input[@id='btnSave']")
    WebElement editTab;

    public MyInfoPage() {
        PageFactory.initElements(driver, this);
    }

    public boolean verifyMyInfoLinkIsDisplayed() {
        return myInfoLink.isDisplayed();


    }


    public void clickOnEditTab() {
        editTab.click();


    }

}
