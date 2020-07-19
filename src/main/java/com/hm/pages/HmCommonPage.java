package com.hm.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.hm.base.HmBase;
import com.hm.util.TimeoutUtil;

public class HmCommonPage extends HmBase{

	
	@FindBy(id="main-search")
	WebElement mainSearchBar;
	
	@FindBy(xpath="//li[@class=\"ui-menu-item\"][1]")
	WebElement firstSearchResultItem;
	
	@FindBy(xpath="//div[contains(@class,'js-cookie-notification')]")
	WebElement cookieNotif;
	
	@FindBy(css=".js-close")
	WebElement closeCookieNotifBtn;
	
	@FindBy(css=".shoppingbag-item-count")
	WebElement shoppingBagCount;
	
	public HmCommonPage() {
		PageFactory.initElements(driver, this);
	}
	
	public void clickMainSearchBar()
	{
		refreshPage();
		TimeoutUtil.explicitWaitforElementVisibility(driver, 10, mainSearchBar);
		mainSearchBar.click();
	}
	
	public void typeItemInSearchBar(String item)
	{
		TimeoutUtil.explicitWaitforElementVisibility(driver, 10, mainSearchBar);
		mainSearchBar.sendKeys(item);
	}
	
	public void selectFirstSearchResultItem()
	{
		TimeoutUtil.explicitWaitforElementVisibility(driver, 5, firstSearchResultItem);
		firstSearchResultItem.click();
	}
	
	public void refreshPage()
	{
		driver.navigate().refresh();
	}
	
	public void cancelCookieNotif()
	{
		if(cookieNotif.isDisplayed())
		{
			closeCookieNotifBtn.click();
		}
	}
	
	public int getCountOfShoppingBagItems()
	{
		TimeoutUtil.explicitWaitforElementVisibility(driver, 10, shoppingBagCount);
		return Integer.parseInt(shoppingBagCount.getText());
	}
	
	public void scrollToElement(WebElement element)
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", element);
	}
}
