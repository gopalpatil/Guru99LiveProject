package com.guru99.live.Utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ReadConfig {
	
	Properties prop;
	
	public ReadConfig() throws IOException
	{
		File src = new File("./Configurations/config.properties");
		FileInputStream fis = new FileInputStream(src);
		prop = new Properties();
		prop.load(fis);

	}
	
	public String getApplicationBaseURL()
	{
		return prop.getProperty("baseurl");
	}
	
	public String getChromeDriverLocation()
	{
		return prop.getProperty("chromedriver");
	}

}
