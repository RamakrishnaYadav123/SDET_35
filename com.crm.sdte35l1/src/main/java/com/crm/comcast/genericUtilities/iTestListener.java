package com.crm.comcast.genericUtilities;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class iTestListener implements ITestListener {

	public void onTestStart(ITestResult result) {
		
	}

	public void onTestSuccess(ITestResult result) {
	
	}

	public void onTestFailure(ITestResult result) {
		
		String testName = result.getMethod().getMethodName();
		System.out.println(testName+"====== Executing =======");
		
		EventFiringWebDriver edriver=new EventFiringWebDriver(BaseClass1.sdriver);
		File src = edriver.getScreenshotAs(OutputType.FILE); 
		try {
			FileUtils.copyFile(src, new File("./screenshot/"+testName+".PNG"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
		
	

	public void onTestSkipped(ITestResult result) {
	
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
	
	}

	public void onTestFailedWithTimeout(ITestResult result) 
	{
		
	}
	public void onStart(ITestContext context) {
		
	}

	public void onFinish(ITestContext context) {
		
	}
	

}
