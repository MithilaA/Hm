package com.hm.tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.hm.base.HmBase;
import com.hm.pages.HmIndexPage;
import com.hm.pages.HomePageOnLogin;

public class HmIndexPageTests extends HmBase{
	
	HmIndexPage hmindexpage;
	HomePageOnLogin homePageOnLogin;
	
	public HmIndexPageTests() {
		super();
	}
	
	@BeforeMethod
	public void setup()
	{
		initialization();
		hmindexpage = new HmIndexPage();
	}
	
	@Test
	public void validateIfHmLogoIsPresent()
	{
		Assert.assertEquals(hmindexpage.isHmLogoPresentOnIndexPage(), true);
	}
	
	@Test
	public void loginWithValidCreds()
	{
		hmindexpage.clickSignInLinkFromIndexPage();
		hmindexpage.loginWithValidCreds(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}

}
