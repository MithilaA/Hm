package com.hm.tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.hm.base.HmBase;
import com.hm.pages.HmIndexPage;
import com.hm.pages.HomePageOnLogin;

public class HomePageOnLoginTests extends HmBase{
	HomePageOnLogin homePageOnLogin;
	HmIndexPage hmIndexPage;
	
	public HomePageOnLoginTests() {
		super();
	}
	
	@BeforeMethod
	public void setup()
	{
		initialization();
		homePageOnLogin = new HomePageOnLogin();
		hmIndexPage = new HmIndexPage();
	}
	
	@Test
	public void validateIfSignInIsChangedToMyAccount() throws InterruptedException
	{
		hmIndexPage.clickSignInLinkFromIndexPage();
		hmIndexPage.loginWithValidCreds(prop.getProperty("username"), prop.getProperty("password"));
		String linkText = homePageOnLogin.checkTheTextOnSignInLinkAfterLogin();
		Assert.assertEquals(linkText, "My Account");
	}
	
	@AfterMethod
	public void  tearDown()
	{
		driver.quit();
	}
	
	
}
