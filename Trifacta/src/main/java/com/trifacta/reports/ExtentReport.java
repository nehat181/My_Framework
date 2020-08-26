package com.trifacta.reports;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.relevantcodes.extentreports.ExtentReports;
import com.trifacta.browser.AutomationContext;
import com.trifacta.utils.ReadPropertyFile;

public class ExtentReport {
	
	public static ExtentReports report=null;
	public static String extentReportPath="";
	
		private ExtentReport() throws IOException {
		SimpleDateFormat formatter = new SimpleDateFormat("MMddyyyy_ hh_mm_ss");
		Date date=new Date();
		String currDate=formatter.format(date);
		if(ReadPropertyFile.get("OverrideResults").equalsIgnoreCase("Yes")) {
			extentReportPath=System.getProperty("user.dir")+"\\ExtentReports\\Test Report.html";
		}
		else {
			extentReportPath=System.getProperty("user.dir")+"\\ExtentReports\\Test Report"+currDate+".html";
		}
		
		report=new ExtentReports(extentReportPath);
		report.loadConfig(new File(System.getProperty("user.dir")+"\\src\\test\\resources\\extentreport.xml"));
		AutomationContext.setExtentReport(report);
		
	}
		
		
		public static void initExtent() throws IOException  {
			
			if(AutomationContext.getExtentReport()==null) {
			 new ExtentReport();
			}
			}
			
}
