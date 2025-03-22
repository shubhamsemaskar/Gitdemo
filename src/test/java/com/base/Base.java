package com.base;

import java.io.File;
import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.Utilities.Utilities;

public class Base {
	
	WebDriver driver;
	public Properties prop;
	public Properties dataProp;

	public  Base() {
		
		 prop=new Properties();
		File propFile=new File(System.getProperty("user.dir")+"\\src\\main\\java\\com\\qa\\config\\Config.properties");
		
		dataProp= new Properties();
		File dataPropFile=new File(System.getProperty("user.dir")+"\\src\\main\\java\\com\\qa\\testdata\\testdata.properties");
		
		try {
			FileInputStream dataFis=new FileInputStream(dataPropFile);
			dataProp.load(dataFis);
			}catch(Throwable e)
			{
				e.printStackTrace();
			}
		
		
		
		try {
		FileInputStream fis=new FileInputStream(propFile);
		prop.load(fis);
		}catch(Throwable e)
		{
			e.printStackTrace();
		}
	}
	
	public WebDriver initializeBrowserAndOpenApplicationURL(String browserName) {
	
			if(browserName.equalsIgnoreCase("chrome")) {
				driver=new ChromeDriver();
			}
			else if(browserName.equalsIgnoreCase("firefox"))
				driver=new FirefoxDriver();
			
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Utilities.IMPLICIT_WAIT_TIME));
			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(Utilities.PAGE_LOAD_TIME));
			driver.get(prop.getProperty("url"));
			
			return driver;
	}

}
