package com.hm.base;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.hm.util.HmEventFiringUtil;
import com.hm.util.TimeoutUtil;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HmBase {
	
	public static WebDriver driver;
	public static Properties prop;
	public static EventFiringWebDriver e_driver;
	public static HmEventFiringUtil hmEventFiringUtil;
	
	public HmBase()
	{
		try
		{
			prop = new Properties();
			FileInputStream inputStream = new FileInputStream("C:/Users/mithilaa/eclipse-workspace/myworkspace/Hm/src/main/java/com/hm/config/environment.properties"); 
			prop.load(inputStream);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	public void initialization()
	{
		String browserName = prop.getProperty("browser");
	
		if(browserName.equals("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		} else 
		if (browserName.equals("firefox"))
		{
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}else
		{
			System.out.println("Invalid browser");
		}
		
		 e_driver = new EventFiringWebDriver(driver);
		hmEventFiringUtil = new HmEventFiringUtil();
		e_driver.register(hmEventFiringUtil);
		driver = e_driver;
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(TimeoutUtil.PAGELOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TimeoutUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		
		driver.get(prop.getProperty("url"));
		
	}
	
}
