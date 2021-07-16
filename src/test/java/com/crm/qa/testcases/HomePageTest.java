package com.crm.qa.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.qa.ExtentReportListener.TestAllureListener;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;

import org.testng.Assert;

@Listeners({TestAllureListener.class})
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
	
	
	@Test(priority = 1, description = "Verifying Home Page title")
	@Severity(SeverityLevel.NORMAL)
	@Description("Test Case Verification: Verify Home Page title")
	@Story("Story Name: To Check Home Page title")
	public void homePageTitleTest()
	{
		Assert.assertEquals(homePage.validateLoginPageTitle(), "#1 Free CRM customer relationship management software cloud", "The title is incorret.");
	
	}
	
	@Test(priority = 2)
	public void crmLogoImageTest()
	{
		Assert.assertTrue(homePage.validateCRMLogo());
	}
	
	@Severity(SeverityLevel.BLOCKER)
	@Description("Test Case Verification: Verify Home Page Button")
	@Story("Story Name: To Check Home Page Button")
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
