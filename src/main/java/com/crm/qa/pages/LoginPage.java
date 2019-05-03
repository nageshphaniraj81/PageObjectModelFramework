package com.crm.qa.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.crm.qa.base.TestBase;

public class LoginPage extends TestBase {
	// Object Repository using FindBy
	@FindBy(name = "username")	
	WebElement username;

	@FindBy(name = "password")
	WebElement password;

	@FindBy(xpath = "//i[@class='fa fa-2x fa-sign-in']")
	@CacheLookup
	WebElement loginBtn;
	
	@FindBy(xpath = "//h2[contains(text(),'Login Page')]")
	@CacheLookup
	WebElement loginPageText;
	
	@FindBy(xpath = "//div[@class='flash error']")
	@CacheLookup
	WebElement invalidLoginErrorMsg;

	// Initializing the Page Objects:
	public LoginPage() {
		PageFactory.initElements(driver, this);
	}

	// Actions
	public String validateLoginPageMessage() {
		return loginPageText.getText();
	}
	
	// Actions:
	public String validateLoginPageTitle() {
		return driver.getTitle();
	}
	
	// Actions
	public boolean validateInvalidLoginError() {
		return invalidLoginErrorMsg.isDisplayed();
	}

	public HomePage login(String un, String pwd) {
		username.sendKeys(un);
		password.sendKeys(pwd);		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", loginBtn);

		return new HomePage();
	}
}
