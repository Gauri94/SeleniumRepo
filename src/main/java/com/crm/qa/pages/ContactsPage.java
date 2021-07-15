package com.crm.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.crm.qa.base.TestBase;

public class ContactsPage extends TestBase {
	
	@FindBy(xpath = "//div[@class = 'ui header item mb5 light-black']")
	WebElement contactsLabel;
	
	@FindBy(xpath = "//*[contains(text(), 'Create')]")
	WebElement createContactButton;
	
	@FindBy(xpath = "//input[@name = 'first_name']")
	WebElement firstName;
	
	@FindBy(xpath = "//input[@name = 'last_name']")
	WebElement lastName;
	
	@FindBy(xpath = "//div[@class = 'ui search selection dropdown']")
	WebElement phoneDropDown;
	
	@FindBy(xpath = "//input[@placeholder = 'Number']")
	WebElement phoneNumber;	
	
	@FindBy(xpath = "//button[@class = 'ui linkedin button']")
	WebElement saveButton;
	
	public ContactsPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	public void clickOnContact(String name)
	{
		driver.findElement(By.xpath("//a[contains(text(), '" +name+ "')]/parent::td//preceding-sibling::td/div")).click();
	}
	
	public String verifyContactsLabel()
	{
		return contactsLabel.getText();
	}

	public void createContact(String firstNameValue, String lastNameValue)
	{
		createContactButton.click();
		driver.navigate().refresh();
		driver.navigate().refresh();
		firstName.sendKeys(firstNameValue);
		lastName.sendKeys(lastNameValue);
//		Select select = new Select(driver.findElement(By.xpath("//div[@class = 'ui search selection dropdown']")));
//		select.selectByVisibleText(countryPhone);
//		phoneNumber.sendKeys(phoneNumberValue);
		saveButton.click();
	}
}
