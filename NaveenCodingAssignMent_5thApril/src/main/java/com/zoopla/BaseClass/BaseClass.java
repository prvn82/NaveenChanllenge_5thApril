package com.zoopla.BaseClass;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

public class BaseClass {
	
	
	private final String FilePath= System.getProperty("user.dir")+"/src/main/java/com/zoopla/properties/config.properties";
	
	FileInputStream fs = null;
	
	public static Properties Config = null;
	
	String BrowserName;
	
	public static WebDriver driver;
	
	
	
	
	@BeforeTest
	public void Setup() throws Exception {
		
		fs = new FileInputStream(new File(FilePath));
		Config=new Properties();
		Config.load(fs);
		
		BrowserName = Config.getProperty("BrowserName");

		if (BrowserName.equalsIgnoreCase("Chrome")) {
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"/chromedriver");
			driver = new ChromeDriver();
			driver.manage().window().setSize(new Dimension(1920, 1200));
		} else if (BrowserName.equalsIgnoreCase("Firefox")) {

			System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+"/geckodriver");

			driver = new FirefoxDriver();
			driver.manage().window().maximize();

		} else if (BrowserName.equalsIgnoreCase("IE")) {

			driver = new InternetExplorerDriver();
		} else {
			throw new Exception("Invalid Browser Name");
		}
		
		
		driver.get(Config.getProperty("Testing_URL"));
		driver.manage().timeouts().implicitlyWait(Integer.parseInt(Config.getProperty("ImplicitWait")), TimeUnit.SECONDS);
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		
		
		
		
		
	}
	
	
@AfterTest
public void TearDown() {
	if(driver!=null) {
			driver.quit();
}
	}

}
