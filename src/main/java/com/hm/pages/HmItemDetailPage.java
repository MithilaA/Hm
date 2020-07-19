package com.hm.pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.hm.base.HmBase;

public class HmItemDetailPage extends HmBase{

	@FindBy(xpath="//div[@class=\"picker small-picker item loaded\"]")
	WebElement sizeDropdown;
	
	@FindBy(xpath="//button[contains(@class,'button-buy')]")
	WebElement addButton;
	
	@FindBy(xpath="//div[@class=\"picker-option\"]//button[@class=\"option\"]")
	List<WebElement> allAvailableSizes;
	
	
	public HmItemDetailPage() {
		PageFactory.initElements(driver, this);
	}
	
	public void selectSizeFromSizeDropDown()
	{
		sizeDropdown.click();
		allAvailableSizes.get(1).click();
		
	}
	
	public void clickAddButton()
	{
		addButton.click();
	}
	
	public void scrollToAddBtn()
	{
		HmCommonPage hmCommonPage = new HmCommonPage();
		hmCommonPage.scrollToElement(addButton);
	}
}

