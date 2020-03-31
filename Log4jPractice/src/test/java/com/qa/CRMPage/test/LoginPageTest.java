package com.qa.CRMPage.test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.log4testng.Logger;


// What is log? ==> Capturing info/activities at the time of program execution is called as log.

// Types of logs:-
// 1. Info
// 2. Warning
// 3. Error
// 4. Fatal

// How to generate the logs? ==> Use Apache log4j API (log4j Jar File).

// Where to create? ==> Create inside resources folder.


public class LoginPageTest
{
	
	WebDriver driver;
	Logger log = Logger.getLogger(LoginPageTest.class);
	
	@BeforeMethod
	public void initialization()
	{
		log.info("****************************************Starting Test Case Execution*******************************************");
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\user\\Desktop\\SeleniumJavaSql_Files\\Selenium_Naveen\\Softwares\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		
		log.info("Launching Chrome Browser");
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		
		driver.get("https://classic.freecrm.com/");
		log.info("The Url is opened");
		log.warn("Hey this is a warning message");
		log.error("This code is having some error in initializing");
		log.fatal("Hey this is just a fatal error message");
		log.debug("This is debug message");
	}
	
	
	@Test(priority=1)
	public void loginPageTitleTest()
	{
		String title = driver.getTitle();
		System.out.println(title);
		Assert.assertEquals(title, "CRMPRO - CRM software for customer relationship management, sales, and support.");
	}
	
	@Test(priority=2)
	public void CRMLogoImageTest()
	{
		boolean logo = driver.findElement(By.xpath("//a[@class='navbar-brand']/img[@class='img-responsive']")).isDisplayed();
		Assert.assertTrue(logo);
	}
	
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
		
		log.info("****************************************Browser Has been Closed*******************************************");
	}

}
