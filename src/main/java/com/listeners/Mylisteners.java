package com.listeners;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class Mylisteners implements ITestListener {

	public static void main(String[] args) {
	}
	
	@Override
	public void onStart(ITestContext context) {
		
		System.out.println("execution of started");
	}


	@Override
	public void onTestStart(ITestResult result) {
		
		
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		
	}

	@Override
	public void onTestFailure(ITestResult result) {
		
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		
	}

	
	@Override
	public void onFinish(ITestContext context) {
	
	}

}
