package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;

public class HomePageTest extends TestBase {
	LoginPage loginPage;
	HomePage homepage;

	public HomePageTest() {
		super();
	}

	@BeforeMethod
	public void setUp() {
		initialization();
		homepage = new HomePage();
		loginPage = new LoginPage();
		loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
	}

	@Test(priority = 1)
	public void homePageSuccessTest() {				
		Assert.assertTrue(homepage.successTxt.isDisplayed());
	}

	@Test(priority = 2)
	public void logoutTest() {
		loginPage = homepage.logout();
		Assert.assertTrue(homepage.logoutSuccessTxt.isDisplayed());
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
