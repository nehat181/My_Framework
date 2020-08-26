package com.trifacta.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.trifacta.browser.AutomationContext;
import com.trifacta.utils.BrowserActions;

public class LoginPage extends BrowserActions  {
	public LoginPage(){
		
		PageFactory.initElements(AutomationContext.getDriver(), this);
	}
	
	@FindBy(xpath="//div[@data-id='email']//input[@class='m-input-text']")
	WebElement email;
	@FindBy(xpath="//div[@data-id='password']//input[@class='m-input-text']")
	WebElement password;
	@FindBy(xpath="//div[@data-id='primary-button']//div[contains(text(),'Log in')]")
	WebElement logIn;
	
	
	public HomePage login(String user,String pwd) {
		sendkeys(email,user);
		sendkeys(password,pwd);
		
		click(logIn);
		return new HomePage();
		
	}

}
