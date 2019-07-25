package com.guru99.live.TestCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.guru99.live.PageObjects.HomePage;

public class TC_HomePageTest extends TestBase{
	
	HomePage homepage;
	
	@Test
	public void verifyHomePageTitle() throws IOException
	{
		homepage = new HomePage(driver);
		logger.info("HomePage elements initialized");
		String HomePageTitle = homepage.getHomePageTitle();
		logger.info("HomePage title has been read");
		Assert.assertTrue(HomePageTitle.equals("Home page"));
		
				
	}
	
	@Test
	public void verifyHomePageLabel() throws IOException
	{
		homepage = new HomePage(driver);
		String HomePageLabel = homepage.getHomePageLabel();
		Assert.assertTrue(HomePageLabel.contains("THIS IS DEMO SITE FOR1"));
		
	}

}
