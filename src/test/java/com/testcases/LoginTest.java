package com.testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.Utilities.Utilities;
import com.base.Base;

public class LoginTest extends Base {
	

	
	public LoginTest() {
		super();
	}
	WebDriver driver;
	
	@BeforeMethod
	public void setup()
	{	
		driver= initializeBrowserAndOpenApplicationURL(prop.getProperty("browserName"));
		driver.findElement(By.xpath("//span[text()='My Account']")).click();
		driver.findElement(By.linkText("Login")).click();	
		

	}
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
	@Test(priority=1,dataProvider="supplyTestData")
	public void verifyLoginWithValidCredentials(String email,String Password)
	{
	

		driver.findElement(By.id("input-email")).sendKeys(prop.getProperty("validEmail"));
		driver.findElement(By.id("input-password")).sendKeys(prop.getProperty("validPassword"));
		driver.findElement(By.xpath("//input[@value='Login']")).click();
	
		Assert.assertTrue(driver.findElement(By.linkText("Edit your account information")).isDisplayed(),"Edit Your Account Information option is not displayed");
		System.out.println("post");	
		System.out.println("post");	
	}
	
	@DataProvider
	public Object[][] supplyTestData() {
		Object[][] data= {{"shubhammsemaskar@gmail.com","bubble00"},
				{"semaskarshubham94@gmail.com","bubble00"},
				{"semaskarshubham@rocketmail.com","bubble00"}};
		return data;
	}
	
	@Test(priority=2)
public void verifyLoginWithInvalidCredentials() {
		
	

		driver.findElement(By.id("input-email")).sendKeys(Utilities.generateTimeStamp());
		driver.findElement(By.id("input-password")).sendKeys("bubble00");
		driver.findElement(By.xpath("//input[@value='Login']")).click();
	
		String acutalWarningMessage =driver.findElement(By.xpath("//div[contains(@class,'alert-dismissible')]")).getText();
		String expectedWarningMessage=dataProp.getProperty("emailPasswordNoMatchWarning");
		Assert.assertTrue(acutalWarningMessage.contains(expectedWarningMessage), "Expected Warning message is not displayed");
		
		
}
	@Test(priority=3)
public void verifyLoginWithInvalidEmailAndValidPassword() {
		
		

		driver.findElement(By.id("input-email")).sendKeys(Utilities.generateTimeStamp());
		driver.findElement(By.id("input-password")).sendKeys(prop.getProperty("validPassword"));
		driver.findElement(By.xpath("//input[@value='Login']")).click();
	
		String acutalWarningMessage =driver.findElement(By.xpath("//div[contains(@class,'alert-dismissible')]")).getText();
		String expectedWarningMessage=dataProp.getProperty("emailPasswordNoMatchWarning");
		Assert.assertTrue(acutalWarningMessage.contains(expectedWarningMessage), "Expected Warning message is not displayed");
		
		
}
	@Test(priority=4)
public void verifyLoginWithvalidEmailAndInvalidPassword() {
	
		

	driver.findElement(By.id("input-email")).sendKeys(prop.getProperty("validEmail"));
	driver.findElement(By.id("input-password")).sendKeys(dataProp.getProperty("invalidPassword"));
	driver.findElement(By.xpath("//input[@value='Login']")).click();
	
	String acutalWarningMessage =driver.findElement(By.xpath("//div[contains(@class,'alert-dismissible')]")).getText();
	String expectedWarningMessage=dataProp.getProperty("emailPasswordNoMatchWarning");
	Assert.assertTrue(acutalWarningMessage.contains(expectedWarningMessage), "Expected Warning message is not displayed");
	
	
}
	@Test(priority=5)
	public void verifyLoginWithoutProvidingCredentials() {
		

		
		driver.findElement(By.xpath("//input[@value='Login']")).click();

		String acutalWarningMessage =driver.findElement(By.xpath("//div[contains(@class,'alert-dismissible')]")).getText();
		String expectedWarningMessage=dataProp.getProperty("emailPasswordNoMatchWarning");
		Assert.assertTrue(acutalWarningMessage.contains(expectedWarningMessage), "Expected Warning message is not displayed");
		
		
	
	}
	
	
	}




