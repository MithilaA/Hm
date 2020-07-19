package com.hm.util;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class TakeScreenshotUtil{

	public static void takeScreenshotAtEndOfTest(WebDriver driver) throws IOException 
	{
		File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		String currentDir = System.getProperty("user.dir");
		System.out.println("Inside TakeSceenshot method -------" + currentDir);
		FileUtils.copyFile(scrFile, new File(currentDir +"\\Screenshots\\" +System.currentTimeMillis()+ ".png"));
		
	}
}
