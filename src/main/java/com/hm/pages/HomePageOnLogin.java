package com.hm.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.hm.base.HmBase;
import com.hm.util.TimeoutUtil;

public class HomePageOnLogin extends HmBase{

	@FindBy(xpath="//a[@class=\"menu__myhm\"][contains(text(),'My Account')]")
	WebElement myAccountLabel;

	public HomePageOnLogin()
	{
		PageFactory.initElements(driver, this);
	}
	
	public String checkTheTextOnSignInLinkAfterLogin()
	{
		TimeoutUtil.explicitWaitforElementVisibility(driver, 10, myAccountLabel);
		return myAccountLabel.getText().trim();
	}
	
	
}
