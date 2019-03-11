package com.training.sanity.tests;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.training.generics.ScreenShot;
import com.training.pom.Scroll;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class scrolltest {

	private WebDriver driver;
	private String baseUrl;
	private Scroll Scroll;
	private static Properties properties;
	private ScreenShot screenShot;

	@BeforeClass
	public static void setUpBeforeClass() throws IOException {
		properties = new Properties();
		FileInputStream inStream = new FileInputStream("./resources/others.properties");
		properties.load(inStream);
	}

	@BeforeMethod
	public void setUp() throws Exception {
		driver = DriverFactory.getDriver(DriverNames.CHROME);
		Scroll = new Scroll(driver); 
		baseUrl = properties.getProperty("baseURL");
		screenShot = new ScreenShot(driver); 
		// open the browser 
		driver.get(baseUrl);
	}
	
	@AfterMethod
	public void tearDown() throws Exception {
		Thread.sleep(30000);
		driver.quit();
	}
	@Test
	public void scrolling() throws InterruptedException {
		Scroll.sendUserName("admin");
		Scroll.sendPassword("admin@123");
		Scroll.clickLoginBtn(); 
		Thread.sleep(5000);
		Scroll.scrollup();
		
		
	
	}
	
	//@Test
	//public void PropertyCheck() {
	//	RealEstateProperty.clickProperty();
		
		
	//}
}
