package com.utilities;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.NoSuchElementException;

import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.FluentWait;

public class Waits {
	
	public static int timeout = 20;
	
	public static FluentWait<WebDriver> returnFluentWait(WebDriver driver)
	throws NumberFormatException, FileNotFoundException, IOException
	{
		FluentWait<WebDriver> wait = new FluentWait<WebDriver>(driver).pollingEvery(Duration.ofSeconds(1)).withTimeout(Duration.ofSeconds(timeout))
		.ignoring(NoSuchElementException.class).ignoring(StaleElementReferenceException.class);
		
		return wait;
		
	}

}
