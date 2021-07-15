package com.crm.qa.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;

import org.testng.Assert;

public class HomePageTest extends TestBase {
	
	HomePage homePage;
	LoginPage loginPage;
	
	public HomePageTest()
	{
		super();
	}
	
	@BeforeMethod
	public void setUp()
	{
		initialization();
		homePage = new HomePage();
	}
	
	
	@Test(priority = 1)
	public void homePageTitleTest()
	{
		Assert.assertEquals(homePage.validateLoginPageTitle(), "#1 Free CRM customer relationship management software cloud", "The title is incorret.");
	
	}
	
	@Test(priority = 2)
	public void crmLogoImageTest()
	{
		Assert.assertTrue(homePage.validateCRMLogo());
	}
	
	@Test(priority = 3)
	public void homeTest()
	{
		loginPage = homePage.home();
	}
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}
	

}
