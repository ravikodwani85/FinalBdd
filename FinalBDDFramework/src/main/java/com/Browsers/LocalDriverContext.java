package com.Browsers;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.WebDriver;

public class LocalDriverContext {
	
	private LocalDriverContext()
	{
		throw new IllegalArgumentException("LocalDriverContext class");
		
	}
	
	public static Map<Integer, WebDriver> driverMap = new HashMap<Integer, WebDriver>();
	
	public static WebDriver getDriver()
	{
		return driverMap.get((int) Thread.currentThread().getId());
	}

	public static void setDriver(WebDriver driver)
	{
		driverMap.put((int) Thread.currentThread().getId(), driver);
	}
	
	
	
}
