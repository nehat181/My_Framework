package com.trifacta.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ReadPropertyFile {
	
	
	public static String get(String propertyname) throws IOException {
		
		String propertyValue="";
		Properties property=new Properties();
		String input=System.getProperty("user.dir")+"/src/test/resources/config.properties";
		System.out.println(input);
		FileInputStream fi=new FileInputStream(input);
		property.load(fi);
		try {
			propertyValue=property.getProperty(propertyname);
			
			if(propertyValue==null) {
				throw new Exception("Property named "+propertyname+ " is not found");
			}
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		
		return propertyValue;
		
		
		
	}

}
