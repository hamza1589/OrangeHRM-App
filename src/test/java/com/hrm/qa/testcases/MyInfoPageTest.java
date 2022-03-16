package com.hrm.qa.testcases;

import com.hrm.qa.base.TestBase;
import com.hrm.qa.pages.DashboardPage;
import com.hrm.qa.pages.LoginPage;
import com.hrm.qa.pages.MyInfoPage;
import com.hrm.qa.util.TestUtil;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class MyInfoPageTest extends TestBase {
    LoginPage loginPage;
    DashboardPage dashboardPage;
    TestUtil testUtil;
    MyInfoPage myInfoPage;

    public MyInfoPageTest() {
        super();
    }

    @BeforeMethod
    public void setUp() {
        initialization();
        testUtil = new TestUtil();
        myInfoPage = new MyInfoPage();
        loginPage = new LoginPage();
        dashboardPage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
    }

    @Test(priority = 1)
    public void verifyMyInfoIsDisplayedTest() {
        Assert.assertTrue(myInfoPage.verifyMyInfoLinkIsDisplayed());
    }

    @Test(priority = 2)
    public void clickOnMyInfoTabTest() {
        dashboardPage.clickOnMyInfoLink();
        myInfoPage.clickOnEditTab();

    }

    @AfterMethod
    public void teaDown() {
        driver.quit();
    }


}
