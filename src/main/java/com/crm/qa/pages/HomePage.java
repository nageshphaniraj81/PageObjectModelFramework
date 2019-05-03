package com.crm.qa.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class HomePage extends TestBase {

	// Object Repository using FindBy

	@FindBy(xpath = "//div[@id='flash']")
	public WebElement successTxt;

	@FindBy(xpath = "//i[@class='icon-2x icon-signout']")
	public WebElement logoutBtn;
	
	@FindBy(xpath = "//div[@id='flash']")
	public WebElement logoutSuccessTxt;

	// Initializing the Page Objects:
	public HomePage() {
		PageFactory.initElements(driver, this);
	}

	// Actions:
	public String validateHomePage() {
		return successTxt.getText();
	}

	public LoginPage logout() {

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", logoutBtn);

		return new LoginPage();
	}

}
