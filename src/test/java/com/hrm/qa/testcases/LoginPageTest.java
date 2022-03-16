package com.hrm.qa.testcases;

import com.hrm.qa.base.TestBase;
import com.hrm.qa.pages.DashboardPage;
import com.hrm.qa.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginPageTest extends TestBase {
    LoginPage loginPage;
    DashboardPage dashboardPage;

    public LoginPageTest() {
        super();
    }

    @BeforeMethod
    public void setUp() {
        initialization();
        loginPage = new LoginPage();

    }

    @Test(priority = 1)
    public void loginPageTitleTest() {
        String title = loginPage.validateLoginPageTitle();
        Assert.assertEquals(title, "OrangeHRM");
    }

    @Test(priority = 2)
    public void crmLogoImageTest() {
        boolean flag = loginPage.validateHRMImage();
        Assert.assertTrue(flag);
    }

    @Test(priority = 3)
    public void loginTest() {
        dashboardPage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
    }
    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
}
