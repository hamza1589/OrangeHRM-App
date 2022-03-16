package com.hrm.qa.testcases;

import com.hrm.qa.base.TestBase;
import com.hrm.qa.pages.AdminPage;
import com.hrm.qa.pages.DashboardPage;
import com.hrm.qa.pages.LoginPage;
import com.hrm.qa.util.TestUtil;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class AdminPageTest extends TestBase {
    LoginPage loginPage;
    DashboardPage dashboardPage;
    TestUtil testUtil;
    AdminPage adminPage;
    String sheetName = "info";


    public AdminPageTest() {
        super();
    }

    @BeforeMethod
    public void setUp() {
        initialization();
        testUtil = new TestUtil();
        adminPage = new AdminPage();
        loginPage = new LoginPage();
        dashboardPage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
        adminPage = dashboardPage.clickOnAdminLink();
    }

    @Test(priority = 1)
    public void verifyAdminPageTest() {
        Assert.assertTrue(adminPage.verifyAdminLabel());
    }

    @Test(priority = 2)
    public void selectingSingleUserTest() {
        adminPage.selectUsersByName("Cecil.Bonaparte");
    }

    @Test(priority = 3)
    public void selectingMultipleUserTest() {
        adminPage.selectUsersByName("Johny123");
        adminPage.selectUsersByName("Kavinda");
    }

    @DataProvider
    public Object[][] getOrangeHRMTestData() {
        Object data[][] = TestUtil.getTestData(sheetName);
        return data;


    }

    @Test(priority = 4, dataProvider = "getOrangeHRMTestData")
    public void validateCreationNewAdminTest(String name, String user, String password, String confirmPassword) {
        dashboardPage.clickOnUserManagementLink();
        adminPage.clickOnAddButton();
        adminPage.createNewAdminUser(name, user, password, confirmPassword);
    }


    @AfterMethod
    public void teaDown() {
        driver.quit();
    }


}
