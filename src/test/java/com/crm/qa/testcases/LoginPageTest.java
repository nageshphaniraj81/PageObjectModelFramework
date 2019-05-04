package com.crm.qa.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.apache.log4j.Logger;
import org.testng.Assert;
import com.crm.qa.base.TestBase;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtil;

public class LoginPageTest extends TestBase {
	
	LoginPage loginPage;
	HomePage homepage;
	//Logger log = TestUtil.getLoggerInstance(LoginPageTest.class);
	Logger log = Logger.getLogger(LoginPageTest.class);

	public LoginPageTest() {
		super();
	}

	@BeforeMethod
	public void setUp() {
		initialization();
		log.info("Initialization successful");
		loginPage = new LoginPage();
	}

	@Test(priority = 1)
	public void validateLoginPage() {	
		log.info("*****************************validateLoginPage started**********************");
		Assert.assertEquals("Login Page", loginPage.validateLoginPageMessage());
		log.info("Login page is displayed");
		log.info("*****************************validateLoginPage ended**********************");
	}

	@Test( dependsOnMethods={"validateLoginPage"},priority = 2)
	public void loginTest() {
		log.info("*****************************loginTest started**********************");
		homepage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		log.info("Login successful");
		log.info("*****************************loginTest ended**********************");
	}
	
	@DataProvider
	public Object[][] getTestData(){
		Object data[][] = TestUtil.getTestData(prop.getProperty("sheetname"));
		return data;
	}
	
	@Test(priority = 3, dataProvider="getTestData")
	public void validateInvalidLogins(String username,String password){	
		log.info("*****************************validateInvalidLogins started**********************");
		homepage = loginPage.login(username ,password);
		Assert.assertTrue(loginPage.validateInvalidLoginError());
		log.info("Invalid login page error is displayed");
		log.info("*****************************validateInvalidLogins ended**********************");
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
