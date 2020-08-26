package com.trifacta.browser;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.testng.SkipException;



public class RemoteConfiguration {

	

	public static void setUpRemote() {
		
			Runtime runtime=Runtime.getRuntime();
			try {
				if(com.trifacta.utils.ReadPropertyFile.get("Mode").equalsIgnoreCase("Remote")){
					try {
						runtime.exec("cmd /c start dockerUp.bat");
						verifyDockerIsUp();
						runtime.exec("cmd /c start scaleChrome.bat");
						Thread.sleep(10000);
						//runtime.exec("cmd /c start scaleFirefox.bat");
						//Thread.sleep(10000);
						runtime.exec("taskkill /f /im cmd.exe") ;
					}
					catch(Exception e) {
						e.printStackTrace();
					}
				
				
				}
				else {
					try {
						throw new Exception("Please set up the remote mode in TestRunDetails.properties correctly. ");
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	


	private static void verifyDockerIsUp() throws FileNotFoundException, Exception {
		Thread.sleep(10000);
		boolean flag=false;
		String file="output.txt";
		BufferedReader reader= new BufferedReader(new FileReader(file));
		String currentline=reader.readLine();

		while(currentline!=null) {
			if((currentline.contains("The node is registered to the hub and ready to use"))||(currentline.contains("Zalenium is now ready!"))) {
				flag=true;
				break;
			}
			currentline=reader.readLine();
		}
		reader.close();

		if(!flag) {
			throw new SkipException("Docker have not started. Please try again or try manually.");
		}
	}



	public static void shutDownRemote() throws IOException {
		Runtime runtime=Runtime.getRuntime();
		if(com.trifacta.utils.ReadPropertyFile.get("Mode").equalsIgnoreCase("Yes")){
			try {
				runtime.exec("cmd /c start dockerDown.bat");
			}
			catch(Exception e) {
				e.printStackTrace();
			}
		}
		
		File file=new File("output.txt");
		if(file.exists()) {
			System.out.println("file deleted");
			file.delete();
		}
		try {
		Thread.sleep(20000);
		runtime.exec("taskkill /f /im cmd.exe") ;
		}
		catch(Exception e) {
			
		}
	}



}
