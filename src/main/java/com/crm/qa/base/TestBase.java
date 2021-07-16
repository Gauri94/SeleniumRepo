package com.crm.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.crm.qa.util.TestUtil;
import com.crm.qa.util.WebEventListener;

public class TestBase {
	
	public static WebDriver driver;
	public static ThreadLocal<WebDriver> tdriver = new ThreadLocal<WebDriver>();
	public static Properties properties;
	public static EventFiringWebDriver e_driver;
	public static WebEventListener eventListener;
	static Logger log = Logger.getLogger(TestBase.class);
	
	
	public TestBase()
		{
		try
		{
			properties = new Properties();
			FileInputStream fis = new FileInputStream(System.getProperty("user.dir") + "/src/main/java/com/crm/qa/config/config.properties");
			properties.load(fis);
		}
		catch(FileNotFoundException e)
		{
			e.printStackTrace();
		}
		catch(Exception exception)
		{
			exception.printStackTrace();
		}
	}
	
	public static synchronized WebDriver getDriver()
	{
		return tdriver.get();
	}

	public static WebDriver initialization()
	{
		String browserName = properties.getProperty("browser");
		
		if(browserName.equals("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", "/Users/gourisoneja/IdeaProjects/Appium/Appium jars/chromedriver");
			driver = new ChromeDriver();
		}
		else if(browserName.equals("firefox"))
		{
			System.setProperty("webdriver.gecko.driver", "/Users/gourisoneja/IdeaProjects/Appium/Appium jars/geckodriver");
			driver = new FirefoxDriver();
		}
		
		log.info("Launching the browser");
		e_driver = new EventFiringWebDriver(driver);
		eventListener = new WebEventListener();
		e_driver.register(eventListener);
		driver = e_driver;
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		log.info("Entering the application URL");
		log.debug("This is just a debug message");
		log.warn("This is just a warning");
		log.fatal("This is a fatal message");
		tdriver.set(driver);
		driver.get(properties.getProperty("URL"));
		return getDriver();
	}

}
