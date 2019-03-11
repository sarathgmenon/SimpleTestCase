package com.training.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class Scroll {
	private WebDriver driver; 

	public Scroll(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}

	// Finding User Id
	@FindBy(id="user_login")
	private WebElement userName; 
	
	// Finding Password
	@FindBy(id="user_pass")
	private WebElement password;
	
	//Finding  Login Button
	@FindBy(name="login")
	private WebElement loginBtn; 

	public void sendUserName(String userName) {
		this.userName.clear();
		this.userName.sendKeys(userName); //User Id Input
	}

	public void sendPassword(String password) {
		this.password.clear(); 
		this.password.sendKeys(password); //Password Input
	}

	public void clickLoginBtn() throws InterruptedException {
		this.loginBtn.click(); //Clicking on Login button
		Thread.sleep(5000);
	}
	
	public void scrollup() {
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("window.scrollBy(0,550)");
	}
}
	