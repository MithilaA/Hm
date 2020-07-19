package com.hm.pages;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.hm.base.HmBase;
import com.hm.util.TimeoutUtil;

public class HmIndexPage extends HmBase{
	@FindBy(xpath = "//a[@class='menu__hm'][contains(@href,'index')]")
	WebElement hmlogo;
	
	@FindBy(xpath = "//div[@class='account parbase']//a[@data-remodal-trigger='signin']")
	WebElement signInLink;
	
	@FindBy(xpath="//button[text() = 'Sign in']")
	WebElement signInBtn;
	
	@FindBy(xpath="//input[@id = \"modal-txt-signin-email\"]")
	WebElement emailOnSignInFrame;
	
	@FindBy(xpath="//input[@id=\"modal-txt-signin-password\"]")
	WebElement passowrdOnSignInFrame;
	
	@FindBy(xpath="//button[@type=\"submit\"][text()='Sign in']")
	WebElement submitSignInBtn;
	
	
	
	public HmIndexPage() 
	{
		PageFactory.initElements(driver, this);
	}
	
	public boolean isHmLogoPresentOnIndexPage()
	{
		return hmlogo.isDisplayed();
	}
	
	public void hoverOverSignInLink()
	{
		
	}
	
	public void loginWithValidCreds(String emailId, String password)
	{
		emailOnSignInFrame.clear();
		emailOnSignInFrame.sendKeys(emailId);
		passowrdOnSignInFrame.clear();
		passowrdOnSignInFrame.sendKeys(password);
		submitSignInBtn.click();

	}
	
	
	public void clickSignInLinkFromIndexPage()
	{
		TimeoutUtil.explicitWaitforElementVisibility(driver, 20, signInLink);
		signInLink.click();
	}
	
	
	
	
	
	
}
