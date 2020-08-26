package com.trifacta.browser;

import java.io.IOException;
import java.net.URL;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import com.trifacta.listeners.*;

import com.trifacta.utils.ReadPropertyFile;


public class Driver {
	
	public WebDriver driver=null;
	public DesiredCapabilities capability;
	private Driver() throws IOException  {
		
		
			if(ReadPropertyFile.get("Mode").equalsIgnoreCase("Local")) {
				setWebDriverLocal();
				
			}
			else			
            if(ReadPropertyFile.get("Mode").equalsIgnoreCase("Remote")) {
				
				setWebDriverRemote();
			}
            else {
            	
        			try {
        				throw new Exception("Please set up the run mode properly in config.properties");
        			} catch (Exception e) {
        				e.printStackTrace();
        			}
        		}
            
	
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Integer.parseInt(ReadPropertyFile.get("WaitTime")), TimeUnit.SECONDS);
		//EventHandlerInit();
		driver.get(ReadPropertyFile.get("url"));
		driver.manage().deleteAllCookies();
		AutomationContext.setDriver(driver);
	}
	
	
	public void setWebDriverLocal() throws IOException {
		String browser=ReadPropertyFile.get("Browser");
		
		try {
			switch(browser) {
			case "Chrome":
				
				System.setProperty("webdriver.chrome.driver", ReadPropertyFile.get("ChromeDriverPath"));
				driver=new ChromeDriver();
				break;
								
				
			case "Firefox":	
				
			
			break;
			default:
				break;
			
			}
		}
		catch(Exception e) {
			
			
		}
		
		
		
	}
	
public void setWebDriverRemote() throws IOException {
	String browser=ReadPropertyFile.get("Browser");
	capability = new DesiredCapabilities();
	try {
		switch(browser) {
		case "Chrome":
			
			
			capability.setBrowserName("chrome");
			capability.setPlatform(Platform.ANY);
			driver=new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"),capability);
			
			
		case "Firefox":	
			
			capability.setBrowserName("firefox");
			capability.setPlatform(Platform.ANY);
			driver=new RemoteWebDriver(new URL(ReadPropertyFile.get("RemoteURL")),capability);
			
		
		break;
		default:
			break;
		
		}
	}
	catch(Exception e) {
		
		
	}
		
		
		
	}


public static void initDriver() {
	
	if(AutomationContext.getDriver()==null) {
		try {
			new Driver();
		}catch(Exception e) {
			e.printStackTrace();
			
		}
		
	}
	
	
}
//private void EventHandlerInit() {
//	EventFiringWebDriver eventhandle = new EventFiringWebDriver(driver);
//	EventCapture capture= new EventCapture();
//	eventhandle.register(capture);
//	driver=eventhandle;
//}

}
