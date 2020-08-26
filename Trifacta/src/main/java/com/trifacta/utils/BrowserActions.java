package com.trifacta.utils;

import java.io.File;
import java.io.IOException;
import java.util.Random;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


import com.trifacta.browser.AutomationContext;
import com.trifacta.listeners.Listener;
import com.trifacta.reports.LogReport;


public class BrowserActions {
	public static Logger Log = Logger.getLogger(BrowserActions.class.getName());
	

	public static void click(WebElement element)  {
		@SuppressWarnings("deprecation")
		WebDriverWait wait = new WebDriverWait(AutomationContext.getDriver(), 20);
		wait.until(ExpectedConditions.elementToBeClickable(element));
		try {
			
	    element.click();
	    
	    Log.info("clicked");
	    LogReport.pass("Clicking is successfull on "+ element);
	    LogReport.pass("Screenshot below", TestUtils.addScreenshot());
		}
		catch(Exception e) {
			
		}
		}



	public static void sendkeys(WebElement element, String text)  {
		
		try {
		WebDriverWait wait = new WebDriverWait(AutomationContext.getDriver(), 20);
		wait.until(ExpectedConditions.visibilityOf(element));
		element.sendKeys(text);
		Log.info("Entered "+text);
		LogReport.pass(text + " is entered in to the "+ element);
		LogReport.pass(text + " is entered in to the "+ element,TestUtils.addScreenshot());
				}
		catch(Exception e) {
			
		}
	}
	public static String getText(WebElement element)  {
		@SuppressWarnings("deprecation")
		WebDriverWait wait = new WebDriverWait(AutomationContext.getDriver(), 20);
		wait.until(ExpectedConditions.visibilityOf(element));
		String val="";
		try {
	     val= element.getText();
	    
	     Log.info("Text read "+val);
	     LogReport.pass("Text is "+ val,TestUtils.addScreenshot());
			
		}
		catch(Exception e) {
			
		}
		return val;
		}
	

}
