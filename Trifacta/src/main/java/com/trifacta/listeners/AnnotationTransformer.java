package com.trifacta.listeners;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

import org.testng.IAnnotationTransformer;
import org.testng.annotations.ITestAnnotation;

import com.trifacta.utils.TestUtils;

public class AnnotationTransformer implements IAnnotationTransformer {

	@SuppressWarnings("rawtypes")
	@Override
	public void transform(ITestAnnotation annotation, Class testClass, Constructor testConstructor, Method testMethod) {
		// TODO Auto-generated method stub
		
		try{
			TestUtils.getRunStatus();
		}catch(Exception e) {
		}
			
			for(int i=0;i<TestUtils.testCases.size();i++) {
				
				if(testMethod.getName().equalsIgnoreCase(TestUtils.testCases.get(i))) {
					annotation.setDataProviderClass(TestUtils.class);
					annotation.setDataProvider("testData");
					
					annotation.setDescription(TestUtils.testDescription.get(i));
					if(TestUtils.runStatus.get(i).equalsIgnoreCase("no")) {
						annotation.setEnabled(false);												
						break;
					}
				}
				
				
			}
			
		}
		
	}


