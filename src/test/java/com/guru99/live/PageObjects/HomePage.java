package com.guru99.live.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	
	WebDriver driver;
	
	@FindBy(xpath="//h2[contains(text(),'This is demo site for')]")
	WebElement pageLabel;
	
	@FindBy(xpath="//a[text()='Mobile']")
	WebElement menuMobile;
	
	public HomePage(WebDriver rdriver)
	{		
		driver = rdriver;
		PageFactory.initElements(driver, this);
	}
	
	public String getHomePageTitle()
	{
		return driver.getTitle();
	}
	
	public String getHomePageLabel()
	{
		return pageLabel.getText();
	}
	
	public void clickMobileMenu()
	{
		menuMobile.click();
	}

}
