package com.guru99.live.Utilities;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class TakeScreenShots {
	
	public void captureScreenshot(String testCaseName, WebDriver driver, Logger logger) throws IOException
	{
		TakesScreenshot screenshot = (TakesScreenshot)driver;
		File src = screenshot.getScreenshotAs(OutputType.FILE);
		File target = new File("./Screenshots/"+testCaseName+".png");
		FileUtils.copyFile(src, target);
		logger.info("Screenshot has been taken for Test Case: "+testCaseName);		
		
	}

}
