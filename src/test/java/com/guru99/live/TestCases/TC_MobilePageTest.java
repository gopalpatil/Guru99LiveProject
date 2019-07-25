package com.guru99.live.TestCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.guru99.live.PageObjects.HomePage;
import com.guru99.live.PageObjects.MobilePage;

public class TC_MobilePageTest extends TestBase{
	
	MobilePage mobilepage;
	HomePage homepage;
	
	@Test
	public void verifyMobilePageTitle() throws IOException
	{
		homepage = new HomePage(driver);
		homepage.clickMobileMenu();
		
		mobilepage = new MobilePage(driver);
		String mobilePageTitle = mobilepage.getMobilePageTitle();
		Assert.assertTrue(mobilePageTitle.equals("MOBILE1"));
		
	}
	
	@Test
	public void verifyProductSortOrder() throws InterruptedException, IOException
	{
		
		homepage = new HomePage(driver);
		homepage.clickMobileMenu();		
		mobilepage = new MobilePage(driver);
		
		mobilepage.clickSortByMenu();
		Thread.sleep(2000);
		boolean flag = mobilepage.isProductSortedByName();
		Assert.assertTrue(flag);
		
				
	}

}
