package com.crm.qa.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.CogmentoHomePage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.qa.ExtentReportListener.TestAllureListener;

@Listeners({TestAllureListener.class})
public class LoginPageTest extends TestBase {
	
	LoginPage loginPage;
	CogmentoHomePage cogmentoHomePage;
	HomePage homePage;
	
	public LoginPageTest()
	{
		super();
	}
	
	@BeforeMethod
	public void setUp()
	{
		initialization();
		homePage = new HomePage();
		homePage.home();
		loginPage = new LoginPage();
	}
	
	@Test
	public void loginTest()
	{
		cogmentoHomePage = loginPage.login(properties.getProperty("userName"), properties.getProperty("password"));
	}
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}
	

}
