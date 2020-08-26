package com.trifacta.listeners;




import org.apache.log4j.Logger;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.trifacta.browser.AutomationContext;
import com.trifacta.reports.ExtentReport;
import com.trifacta.reports.LogReport;




public class Listener implements ITestListener{

	public static Logger Logg = Logger.getLogger(Listener.class.getName());
	
	private static String TestcaseName;

	public static String getTestcaseName() {
		return TestcaseName;
	}

	public static void setTestcaseName(String testcaseName) {
		TestcaseName = testcaseName;
	}
	@Override
	public void onTestStart(ITestResult result) {
		setTestcaseName(result.getMethod().getMethodName());
		AutomationContext.setextenttest(ExtentReport.report.startTest(TestcaseName));
		LogReport.pass(getTestcaseName()+" test case has started executing");
		Logg.info(result.getMethod().getMethodName()+" has started");
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		
		LogReport.pass(result.getMethod().getDescription()+" test case has passed");
		ExtentReport.report.endTest(AutomationContext.getextenttest());
		
		
	}

	@Override
	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		LogReport.fail(result.getMethod().getDescription() + " is failed");
		LogReport.fail(result.getThrowable().toString());
		LogReport.fail("Failed", com.trifacta.utils.TestUtils.addScreenshot());
		ExtentReport.report.endTest(AutomationContext.getextenttest());

	}

	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		Logg.info(context.getName()+" testcase has started executing");
		
	}

	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		ExtentReport.report.endTest(AutomationContext.getextenttest());	
	}

}
