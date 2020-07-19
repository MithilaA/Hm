package com.hm.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.hm.base.HmBase;
import com.hm.util.TimeoutUtil;

public class HmSearchResultPage extends HmBase{

	@FindBy(xpath="//li[@class=\"product-item\"][1]")
	WebElement firstProductOnSearchResultsPage;
	
	public HmSearchResultPage() {
		PageFactory.initElements(driver, this);
	}
	
	public void clickFirstSearchResult()
	{
		TimeoutUtil.explicitWaitforElementVisibility(driver, 10, firstProductOnSearchResultsPage);
		firstProductOnSearchResultsPage.click();
	}
	
}
