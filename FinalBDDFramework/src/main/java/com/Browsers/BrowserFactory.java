package com.Browsers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import appconstants.AppConstants;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BrowserFactory {
	
	private BrowserFactory()
	{
		throw new IllegalStateException("Browser type class");
	}

	public static WebDriver getDriver()
	{
		WebDriver driver = null;
		
		switch (AppConstants.BrowserType.toLowerCase()) {
		case ("chrome"):
			
			//System.setProperty("webdriver.chrome.driver", "C:\\Projects\\chromerdriver.exe");
		WebDriverManager.chromedriver().setup();
		
		driver = new ChromeDriver();
			break;

		default:
			
			System.out.println("incorrect Browser identifier");
		
		}
	return driver;
	}
	
	
}
