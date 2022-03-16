package com.hrm.qa.testcases;

import com.hrm.qa.base.TestBase;
import com.hrm.qa.pages.DashboardPage;
import com.hrm.qa.pages.LoginPage;
import com.hrm.qa.util.TestUtil;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DashboardPageTest extends TestBase {
    LoginPage loginPage;
    DashboardPage dashboardPage;
    TestUtil testUtil;

    public DashboardPageTest() {
        super();
    }

    @BeforeMethod
    public void setUp() {
        initialization();
        testUtil = new TestUtil();
        loginPage = new LoginPage();
        dashboardPage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
    }

    @Test(priority = 1)
    public void verifyDashboardTitleTest() {
        String homePageTitle = dashboardPage.verifyHomePageTitle();
        Assert.assertEquals(homePageTitle, "OrangeHRM");

    }

    @Test(priority = 2)
    public void verifyDashBoardHeaderTest() {
        Assert.assertTrue(dashboardPage.verifyDashboardHeaderIsDisplayed());
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }


}
