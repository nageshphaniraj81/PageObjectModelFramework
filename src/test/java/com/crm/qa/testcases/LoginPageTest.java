package com.crm.qa.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.Assert;
import com.crm.qa.base.TestBase;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtil;

public class LoginPageTest extends TestBase {
	//What is log? : capturing info/activities at the time of program execution. 
	// types of logs:
		//1. info
		//2. warn
		//3. debug
		//4. fatal
		
	//how to generate the logs? : use Apache log4j API (log4j jar)
	//How it works? : it reads log 4j configuration from log4j.properties file
	//where to create: create inside resources folder
	
	LoginPage loginPage;
	HomePage homepage;

	public LoginPageTest() {
		super();
	}

	@BeforeMethod
	public void setUp() {
		initialization();
		loginPage = new LoginPage();
	}

	@Test(priority = 1)
	public void validateLoginPage() {
		Assert.assertEquals("Login Page", loginPage.validateLoginPageMessage());
	}

	@Test( dependsOnMethods={"validateLoginPage"},priority = 2)
	public void loginTest() {
		homepage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	@DataProvider
	public Object[][] getTestData(){
		Object data[][] = TestUtil.getTestData(prop.getProperty("sheetname"));
		return data;
	}
	
	@Test(priority = 3, dataProvider="getTestData")
	public void validateInvalidLogins(String username,String password){		
		homepage = loginPage.login(username ,password);
		Assert.assertTrue(loginPage.validateInvalidLoginError());
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
