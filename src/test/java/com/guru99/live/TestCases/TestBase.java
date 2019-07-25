package com.guru99.live.TestCases;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.guru99.live.Utilities.ReadConfig;

public class TestBase {
	
	public static WebDriver driver;
	public static Logger logger;
	
	@Parameters("browser")
	@BeforeMethod
	public void setUp(@Optional("Chrome") String browser) throws IOException
	{
		ReadConfig readConfig = new ReadConfig();
		
		if(browser.equals("Chrome"))
		{
			System.setProperty("webdriver.chrome.driver", readConfig.getChromeDriverLocation());
			driver = new ChromeDriver();
			
			 
		}
		
		driver.get(readConfig.getApplicationBaseURL());	
		
		logger = Logger.getLogger("Guru99LiveProject");
		PropertyConfigurator.configure("log4j.properties");
		
	}
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}
	
	
	

}
