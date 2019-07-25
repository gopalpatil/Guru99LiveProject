package com.guru99.live.PageObjects;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class MobilePage {
	
	WebDriver driver;
	
	@FindBy(xpath="//select[@title='Sort By' and ancestor::div[@class='toolbar']/parent::div[@class='category-products']]")
	WebElement menuSortBy;
	
	@FindBy(xpath="//li[@class='item last']//h2[@class='product-name']/a")
	List<WebElement> products;
	
	@FindBy(xpath="//div[@class='page-title category-title']/h1")
	WebElement mobilePageTitle;
	
	public MobilePage(WebDriver rdriver)
	{
		driver = rdriver; 
		PageFactory.initElements(driver, this);
	}
	
	public String getMobilePageTitle()
	{
		//System.out.println("Mobile Page Title = "+driver.getTitle());
		if(mobilePageTitle.getCssValue("text-transform").equals("uppercase"))
		{
			return driver.getTitle().toUpperCase();
		}
		else
		{
			return driver.getTitle();
		}
		
	}
	
	public void clickSortByMenu()
	{
		menuSortBy.click();
		Select select = new Select(menuSortBy);
		select.selectByVisibleText("Name");
	}
	
	
	public ArrayList<String> getProducts()
	{
		//String[] productArray = new String[products.size()];
		ArrayList<String> productArray = new ArrayList<String>();

		for(WebElement product : products)
		{
			
			//System.out.println("Product : "+product.getText());
			//productArray[i] = product.getText();
			productArray.add(product.getText());
			
		}
		
		return productArray;
	}
	
	public boolean isProductSortedByName()
	{
		ArrayList<String> productArray = getProducts();
		boolean flag = false;
		
		A: for(int k=0; k<products.size();k++)
		{
			for(int j=k+1; j<products.size();j++)
			{
				//System.out.println(productArray.get(k)+" Comparing with "+productArray.get(j));
				if(productArray.get(k).compareToIgnoreCase(productArray.get(j))<0)
				{
					flag = true;
				}
				else
				{
					flag = false;
					break A;
				}
			}
		}
		//System.out.println("FLAG = "+flag);
		return flag;
	}

}
