package com.trifacta.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.trifacta.browser.AutomationContext;
import com.trifacta.utils.BrowserActions;

public class HomePage extends BrowserActions {
	
public HomePage(){
		
		PageFactory.initElements(AutomationContext.getDriver(), this);
	}
	
	@FindBy(xpath="//div[@class='m-icon help tricon']")
	WebElement help;
	@FindBy(xpath="//div[text()='About Trifacta Wrangler']")
	WebElement about;
	@FindBy(xpath="//h4[text()='Version']//following::p[1]")
	WebElement productVersion;
	@FindBy(xpath="//div[@data-id='element-settings']")
	WebElement avatar;
	@FindBy(xpath="//*[contains(text(),'Log out')]")
	WebElement logout;
	@FindBy(xpath="//button[@class='close tricon']")
	WebElement close;
	
	
	
	public String showProductVersion() {
		
		click(help);
		click(about);
		return getText(productVersion);
		
	}
	public void closeAboutWindow() {
		click(close);
	}
	
public void logOut() {
		
		click(avatar);
		click(logout);
		
		
	}
	
}
