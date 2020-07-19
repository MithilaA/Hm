package com.hm.tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.hm.base.HmBase;
import com.hm.pages.HmCommonPage;
import com.hm.pages.HmIndexPage;
import com.hm.pages.HmItemDetailPage;
import com.hm.pages.HmLoginPage;
import com.hm.pages.HmSearchResultPage;
import com.hm.util.DataReaderUtil;

public class HmBaseTest extends HmBase{
	HmCommonPage hmCommonPage;
	HmIndexPage hmIndexPage;
	HmLoginPage hmLoginPage;
	HmSearchResultPage hmSearchResultPage;
	HmItemDetailPage hmItemDetailPage;
	String sheetName = "Item_Names";
	
	public HmBaseTest() {
		super();
	}
	
	
	@BeforeMethod
	public void setup()
	{
		initialization();
		hmCommonPage = new HmCommonPage();
		hmIndexPage = new HmIndexPage();
		hmLoginPage = new HmLoginPage();
		hmSearchResultPage = new HmSearchResultPage();
		hmItemDetailPage = new HmItemDetailPage();
 	}
	
	@DataProvider
	public Object[][] getHmTestData()
	{
		Object data[][] = DataReaderUtil.getTestData(sheetName);
		return data;
	}
	
	@Test
	public void verifyDefaultCountOfShoppingBagisZeroWithoutLogin()
	{
		Assert.assertEquals(hmCommonPage.getCountOfShoppingBagItems(), 0);
	}
	
	@Test
	public void verifyDefaultCountOfShoppingBagisZeroOnLogin()
	{
		hmIndexPage.clickSignInLinkFromIndexPage();
		hmIndexPage.loginWithValidCreds(prop.getProperty("username"), prop.getProperty("password"));
		hmCommonPage.cancelCookieNotif();
		Assert.assertEquals(hmCommonPage.getCountOfShoppingBagItems(), 0);
	}
	
	@Test(dataProvider = "getHmTestData")
	public void validateShoppingBagCountUpdate(String Item_Name)
	{
		hmIndexPage.clickSignInLinkFromIndexPage();
		hmIndexPage.loginWithValidCreds(prop.getProperty("username"), prop.getProperty("password"));
		hmCommonPage.cancelCookieNotif();
		int oldCount = hmCommonPage.getCountOfShoppingBagItems();
		hmCommonPage.clickMainSearchBar();
		hmCommonPage.typeItemInSearchBar(Item_Name);
		hmCommonPage.selectFirstSearchResultItem();
		hmSearchResultPage.clickFirstSearchResult();
		hmItemDetailPage.selectSizeFromSizeDropDown();
		hmItemDetailPage.scrollToAddBtn();
		hmItemDetailPage.clickAddButton();
		int newCount = oldCount + 1;
		Assert.assertEquals(newCount, oldCount+1);
	}
	
//	@Test(dataProvider = "getHmTestData")
//	public void validateShoppingBagCountMultipleItems(String Item_Name)
//	{	
//		hmIndexPage.clickSignInLinkFromIndexPage();
//		hmIndexPage.loginWithValidCreds(prop.getProperty("username"), prop.getProperty("password"));
//		hmCommonPage.cancelCookieNotif();
//		int oldCount = hmCommonPage.getCountOfShoppingBagItems();
//		int newCount = 0;
//		hmCommonPage.clickMainSearchBar();
//		while(Item_Name != null)
//		{
//			hmCommonPage.typeItemInSearchBar(Item_Name);
//			hmCommonPage.selectFirstSearchResultItem();
//			hmSearchResultPage.clickFirstSearchResult();
//			hmItemDetailPage.selectSizeFromSizeDropDown();
//			hmItemDetailPage.scrollToAddBtn();
//			hmItemDetailPage.clickAddButton();
//			newCount = oldCount + 1;
//		}
//		Assert.assertEquals(newCount, oldCount+10);
//	}
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}
}
