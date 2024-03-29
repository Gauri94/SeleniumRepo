package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

import io.qameta.allure.Step;

public class LoginPage extends TestBase{

	//Page Factory ---- Object Repository
	@FindBy(xpath = "//input[@name = 'email']")
	WebElement emailField;
	
	@FindBy(xpath = "//input[@name = 'password']")
	WebElement passwordField;
	
	@FindBy(xpath = "//div[text() = 'Login']")
	WebElement loginCRMButton;
	
	// Initialising the Page Objects
	public LoginPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	@Step("Login with username: {0} and password {1} step")
	public CogmentoHomePage login(String userName, String password)
	{
		emailField.sendKeys(userName);
		passwordField.sendKeys(password);
		loginCRMButton.click();
		return new CogmentoHomePage();
	}
}
