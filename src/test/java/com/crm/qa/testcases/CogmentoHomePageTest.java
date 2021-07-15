package com.crm.qa.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.CogmentoHomePage;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;

import org.testng.Assert;

public class CogmentoHomePageTest extends TestBase {
	
	CogmentoHomePage cogmentoHomePage;
	HomePage homePage;
	LoginPage loginPage;
	ContactsPage contactsPage;
	
	public CogmentoHomePageTest()
	{
		super();
	}
	
	@BeforeMethod
	public void setUp()
	{
		initialization();
		homePage = new HomePage();
		loginPage = new LoginPage();
		contactsPage = new ContactsPage();
		homePage.home();
		loginPage.login(properties.getProperty("userName"), properties.getProperty("password"));
		cogmentoHomePage = new CogmentoHomePage();
	}
	
	@Test
	public void contacts()
	{
		contactsPage = cogmentoHomePage.clickOnContactsPage();
	}
	
	@Test
	public void nameLabel()
	{
		Assert.assertTrue(cogmentoHomePage.validateName());
	}
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}

}
