package com.trifacta.reports;

import com.trifacta.browser.AutomationContext;
import com.trifacta.utils.ReadPropertyFile;

import java.io.IOException;

import com.relevantcodes.extentreports.LogStatus;


public class LogReport {
	
	private LogReport() {
		
	}
	
	public static void pass(String message) {
		
		AutomationContext.getextenttest().log(LogStatus.PASS, message);
	}
public static void fail(String message) {
		
		AutomationContext.getextenttest().log(LogStatus.FAIL, message);
	}

public static void fail(Exception message)
{
	AutomationContext.getextenttest().log(LogStatus.FAIL, message);
}

public static void info(String message)
{
	AutomationContext.getextenttest().log(LogStatus.INFO, message);
}


public static void skip(String message)
{
	AutomationContext.getextenttest().log(LogStatus.SKIP, message);
}



public static void warning(String message)
{
	AutomationContext.getextenttest().log(LogStatus.WARNING, message);
}
public static void pass(String string, String addScreenCapture) {

	try {
		if(ReadPropertyFile.get("PassedStepsScreenshots").equalsIgnoreCase("yes")) {
			AutomationContext.getextenttest().log(LogStatus.PASS, string,AutomationContext.getextenttest().addScreenCapture(addScreenCapture));
		}
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}

public static void fail(String string, String addScreenCapture)
{

	try {
		if(ReadPropertyFile.get("FailedStepsScreenshots").equalsIgnoreCase("yes")) {
			AutomationContext.getextenttest().log(LogStatus.FAIL, string,AutomationContext.getextenttest().addScreenCapture(addScreenCapture));
		}
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}

}

public static void skip(String string, String addScreenCapture)
{
	try {
		if(ReadPropertyFile.get("SkippedStepsScreenshots").equalsIgnoreCase("yes")) {
			AutomationContext.getextenttest().log(com.relevantcodes.extentreports.LogStatus.SKIP, string,AutomationContext.getextenttest().addScreenCapture(addScreenCapture));
		}
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}

}
}
