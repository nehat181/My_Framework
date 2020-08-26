package com.trifacta.browser;

import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.trifacta.reports.ExtentReport;

public class AutomationContext {

	public static ThreadLocal<WebDriver> webdriver=new ThreadLocal<WebDriver>();
	public static ThreadLocal<ExtentTest> extenttest=new ThreadLocal<ExtentTest>();
	public static ThreadLocal<ExtentReports> extentreport=new ThreadLocal<ExtentReports>();
	
	public static WebDriver getDriver() {
		return webdriver.get();
		
	}
public static void setDriver(WebDriver driver) {
		
	webdriver.set(driver);
	}
public static ExtentTest getextenttest() {
	return extenttest.get();
	
}
public static void setextenttest(ExtentTest test) {
	
	extenttest.set(test);
}

public static ExtentReports getExtentReport() {
	return extentreport.get();
	
}
public static void setExtentReport(ExtentReports report) {
	
	extentreport.set(report);
}


}
