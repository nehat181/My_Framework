package com.trifacta.scripts;
import java.util.Hashtable;

import org.testng.annotations.Test;

import com.trifacta.pages.LoginPage;

public class Login extends BaseTest{
	
  @Test
  public void LoginToTrifacto(Hashtable<String,String> data) {
	  try {
		  
	  LoginPage login =new LoginPage();
	  login.login(data.get("username"),data.get("password"));
	  
  }
  catch(Exception e) {
	  
  }
  }
}
