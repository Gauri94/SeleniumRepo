package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class CogmentoHomePage extends TestBase {
	
	@FindBy(xpath = "//span[@class = 'user-display']")
	WebElement nameText;
	
	@FindBy(xpath = "//div[@id = 'main-nav']")
	WebElement menu;
	
	@FindBy(xpath = "//i[@class = 'calendar icon']")
	WebElement calendarIcon;
	
	@FindBy(xpath = "//span[contains(text(), 'Contacts')]")
	WebElement contactsIcon;
	
	@FindBy(xpath = "//i[@class = 'money icon']")
	WebElement dealsIcon;
	
	@FindBy(xpath = "//i[@class = 'tasks icon']")
	WebElement taskIcon;
	
	public CogmentoHomePage()
	{
		PageFactory.initElements(driver, this);
	}
	
	public void hoverOverMenu()
	{
		Actions action = new Actions(driver);
		action.moveToElement(menu).perform();;
		
	}
	
	public ContactsPage clickOnContactsPage()
	{
		Actions action = new Actions(driver);
		action.moveToElement(menu).click(contactsIcon).perform();
		action.moveByOffset(200, 200).click().build().perform();
		return new ContactsPage();
	}
	
	public DealsPage clickOnDealsPage()
	{
		dealsIcon.click();
		return new DealsPage();
	}
	
	public TaskPage clickOnTaskPage()
	{
		taskIcon.click();
		return new TaskPage();
	}
	
	public CalendarPage clickOnCalendarPage()
	{
		calendarIcon.click();
		return new CalendarPage();
	}
	
	public boolean validateName()
	{
		return nameText.isDisplayed();
	}

}
