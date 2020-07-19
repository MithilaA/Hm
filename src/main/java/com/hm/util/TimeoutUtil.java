package com.hm.util;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TimeoutUtil{

	public static long PAGELOAD_TIMEOUT = 20;
	public static long IMPLICIT_WAIT = 20;
	public static WebDriverWait wait;
	
	public static void explicitWaitforElementVisibility(WebDriver driver, long timeInSeconds, WebElement element)
	{
	 new WebDriverWait(driver, timeInSeconds).until(ExpectedConditions.visibilityOf(element));
	}
	
	public static void applyStaticWait(long timeInSeconds) throws InterruptedException
	{
		timeInSeconds = timeInSeconds * 1000;
		Thread.sleep(timeInSeconds);
	}

	public static void takeScreenshotAtEndOfTest() {
		// TODO Auto-generated method stub
		
	}
}
