package com.crm.qa.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.CogmentoHomePage;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtil;
import com.qa.ExtentReportListener.TestAllureListener;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.Assert;

@Listeners({TestAllureListener.class})
public class ContactsPageTest extends TestBase{
	
	ContactsPage contactsPage;
	HomePage homePage;
	LoginPage loginPage;
	CogmentoHomePage cogmentoHomePage;
	
	String sheetName = "contacts";
	
	public ContactsPageTest()
	{
		super();
	}
	
	@BeforeMethod()
	public void setUp()
	{
		initialization();
		contactsPage = new ContactsPage();
		homePage = new HomePage();
		loginPage = new LoginPage();
		cogmentoHomePage = new CogmentoHomePage();
		homePage.home();
		loginPage.login(properties.getProperty("userName"), properties.getProperty("password"));
		contactsPage = cogmentoHomePage.clickOnContactsPage();
	}
	
	@Test (enabled = false)
	public void contactsLabelText()
	{
		Assert.assertEquals(contactsPage.verifyContactsLabel(), "Contacts");
	}
	
	@Test (enabled = false)
	public void selectContactText()
	{
		contactsPage.clickOnContact("Gouri Soneja");
	}
	
	@Test (enabled = false)
	public void selectMultipleContacts()
	{
		contactsPage.clickOnContact("Gouri Soneja");
		contactsPage.clickOnContact("Casey Purple");
	}
	
	@DataProvider
	public Object[][]  getCRMTestData() throws InvalidFormatException
	{
		return TestUtil.getTestData(sheetName);
	}
	
	@Test (dataProvider = "getCRMTestData")
	public void validateCreateNewContact(String firstName, String lastName)
	{
		//contactsPage.createContact("Zendaya", "Turner");
		contactsPage.createContact(firstName, lastName);
	}	
	
	@AfterMethod()
	public void tearDown()
	{
		driver.quit();
	}
	
}
