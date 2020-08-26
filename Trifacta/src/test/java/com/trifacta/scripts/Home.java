package com.trifacta.scripts;

import java.util.Hashtable;

import org.testng.annotations.Test;

import com.trifacta.pages.HomePage;
import com.trifacta.pages.LoginPage;
import com.trifacta.utils.Assertion;

public class Home extends BaseTest{
	
  @Test
  public void TC_01(Hashtable<String,String> data) {
	  try {
		 
	  LoginPage login =new LoginPage();
	  HomePage home=login.login(data.get("username"),data.get("password"));
	  home.showProductVersion();
	  home.closeAboutWindow();
	  home.logOut();
	  
	  
  }
  catch(Exception e) {
	  
  }
	  finally {
		  Assertion.assertAll();
	  }
  
  }
  
	
  @Test
  public void TC_02(Hashtable<String,String> data) {
	  try {
		 
	  LoginPage login =new LoginPage();
	  HomePage home=login.login(data.get("username"),data.get("password"));
	 
	  
	  home.logOut();
	  
	  
  }
  catch(Exception e) {
	  
  }
	  finally {
		  Assertion.assertAll();
	  }
  
  }
}
