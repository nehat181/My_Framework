package com.trifacta.scripts;

import java.io.IOException;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.trifacta.browser.RemoteConfiguration;
import com.trifacta.browser.AutomationContext;
import com.trifacta.browser.Driver;
import com.trifacta.reports.ExtentReport;
import com.trifacta.utils.ReadPropertyFile;

public class BaseTest {
  
  @BeforeMethod
  public void setup() {
	  try {
			Driver.initDriver();
		} catch (Exception e) {
			e.printStackTrace();
		}
  }

  @AfterMethod
  public void closeSession() {
	  
	  AutomationContext.getDriver().close();	

  }

  @BeforeSuite
  public void beforeSuite() throws IOException {
	  
	ExtentReport.initExtent();
	if(ReadPropertyFile.get("Mode").equalsIgnoreCase("Remote"))
		RemoteConfiguration.setUpRemote();
}
  

  @AfterSuite
  public void afterSuite() throws IOException {
	  
	  ExtentReport.report.flush();
	  if(ReadPropertyFile.get("Mode").equalsIgnoreCase("Remote")) {
			RemoteConfiguration.shutDownRemote();
		}
		
  }

}
