package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class HomePage extends TestBase{
	
	//Page Factory ---- Object Repository
		@FindBy(xpath = "//*[text() = 'Log In']")
		@CacheLookup
		WebElement loginButton;
		
		@FindBy(xpath = "//div[@class = 'rd-navbar-panel']")
		@CacheLookup
		WebElement crmLogo;
		
		// Initialising the Page Objects
		public HomePage()
		{
			PageFactory.initElements(driver, this);
		}
		
		// Actions
		public String validateLoginPageTitle()
		{
			return driver.getTitle();
		}
		
		public boolean validateCRMLogo()
		{
			return crmLogo.isDisplayed();
		}
		
		public LoginPage home()
		{
			loginButton.click();
			return new LoginPage();
		}

}
