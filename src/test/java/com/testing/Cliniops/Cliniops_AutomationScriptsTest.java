package com.testing.Cliniops;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class Cliniops_AutomationScriptsTest extends Cliniops_ReusableMethodsTest{

WebDriver dr;

	@BeforeTest
	@Parameters("browser")
	public void Selectbrowser(String browser){
		if(browser.equalsIgnoreCase("firefox")){
			//System.setProperty("webdriver.firefox.marionette", "C:/Users/Zunaira's/Documents/QA automation/geckodriver-v0.16.1-win64/geckodriver.exe");
			dr=new FirefoxDriver();	
			dr.manage().window().maximize();

		}
		else if(browser.equalsIgnoreCase("chrome")){
			//System.setProperty("webdriver.chrome.driver", "C:/Users/Zunaira's/Documents/QA automation/chromedriver.exe");
			dr=new ChromeDriver();
			dr.manage().window().maximize();

		}
		else if(browser.equalsIgnoreCase("IE")){
			//System.setProperty("webdriver.ie.driver", "C:/Users/Zunaira's/Documents/QA automation/IEDriverServer.exe");
	        dr=new InternetExplorerDriver();
	        dr.manage().window().maximize();
		}
		
	}
	

	@Test
	public void loginErrorMessage1() throws IOException{
		
		dr.get("https://bridgetherapeutics.cliniops.com");
		Thread.sleep(3000);
		
		WebElement username= dr.findElement(By.id("username"));
		enterText(username, "Abhishek", "Username field");
		
		WebElement pwd= dr.findElement(By.id("password"));
		enterText(pwd, "welcome", "Password field");
		
		WebElement authBtn= dr.findElement(By.id("Authenticate"));
		clickObj(authBtn, "Authenticate Button");
		
		WebElement errorMsg=dr.findElement(By.className("error"));
		String error= errorMsg.getText();
		String expectedText="Please enter the user name";
		
		validateMsg(errorMsg, expectedText, error);
	
	}
	@Test
	public void sucessFulLogin1() throws IOException{
		
		dr.get("https://bridgetherapeutics.cliniops.com");
		
		WebElement username= dr.findElement(By.id("username"));
		enterText(username, "Abhishek", "Username field");
		
		WebElement pwd= dr.findElement(By.id("password"));
		enterText(pwd, "Welcome123#", "Password field");
		
		WebElement authBtn= dr.findElement(By.id("Authenticate"));
		clickObj(authBtn, "Authenticate Button");
		Thread.sleep(3000);
		
		
		WebElement dd1=dr.findElement(By.id("investigator_study"));
		dropDown(dd1, 0);
		Thread.sleep(3000);

		WebElement dd2=dr.findElement(By.name("lang_type"));
		Select select = new Select(dd2);
		select.selectByValue("1");
		
		WebElement clickLogin= dr.findElement(By.className("login-btnew disable"));
		clickObj(clickLogin, "Login");




}
		 @Test
		 public void loginErrorMessage2() throws IOException, InterruptedException{
		  
		  dr.get("https://bridgetherapeutics.cliniops.com");
		  
		  WebElement username= dr.findElement(By.id("username"));
		  enterText(username, "", "Username field");
		  
		  WebElement pwd= dr.findElement(By.id("password"));
		  enterText(pwd, "", "Password field");
		  Thread.sleep(4000);
		  WebElement authBtn= dr.findElement(By.id("Authenticate"));
		  clickObj(authBtn, "Authenticate Button");
		  WebElement usererrorMsg=dr.findElement(By.xpath("//*[text()='Please enter the username']"));
		  String error1= usererrorMsg.getText();
		  String expectedText1="Please enter the user name";
		  validateMsg(usererrorMsg, expectedText1, error1);
		  WebElement pwderrorMsg=dr.findElement(By.xpath("//*[text()='Please enter the password']"));
		  String error2= pwderrorMsg.getText();
		  String expectedText2="Please enter the password";
		  validateMsg(pwderrorMsg, expectedText2, error2);
	 }
		 
		 
		 @Test
		 public void loginErrorMessage3() throws IOException, InterruptedException{
		  
		  dr.get("https://bridgetherapeutics.cliniops.com");
		  
		  WebElement username= dr.findElement(By.id("username"));
		  enterText(username, "", "Username field");
		  
		  WebElement pwd= dr.findElement(By.id("password"));
		  enterText(pwd, "", "Password field");
		  Thread.sleep(4000);
		  WebElement authBtn= dr.findElement(By.id("Authenticate"));
		  clickObj(authBtn, "Authenticate Button");
		  WebElement usererrorMsg=dr.findElement(By.xpath("//*[text()='Please enter the username']"));
		  
		  WebElement pwderrorMsg=dr.findElement(By.xpath("//*[@id='login']/div[2]/label"));
		  String error2= pwderrorMsg.getText();
		  String expectedText2="Please enter the password";
		  validateMsg(pwderrorMsg, expectedText2, error2);
		  Thread.sleep(3000);
		 }
		 
		 @Test
		 public void forgotPassword() throws IOException, InterruptedException{
			 
			 dr.get("https://bridgetherapeutics.cliniops.com");
			 
			 WebElement username= dr.findElement(By.id("username"));
			  enterText(username, "Abhishek", "Username field");
			 Thread.sleep(3000);
			 WebElement forgotPwd=dr.findElement(By.linkText("Forgot password..? Click here..."));
			 forgotPwd.click();
			 Thread.sleep(3000);
			 WebElement email=dr.findElement(By.id("forgotemail"));
			 enterText(email, "abc@gmail.com", "Email id");
			 Thread.sleep(3000);
			 WebElement requestNewPwd=dr.findElement(By.id("req_new_pass"));
			 clickObj(requestNewPwd, "Request new password");
			 Thread.sleep(3000);
			 WebElement emailIdError=dr.findElement(By.id("errorserver"));
			 String errorMsg=emailIdError.getText();
			 String actualErrorMsg="Email-id does not exist in database.";
			 validateMsg(emailIdError, actualErrorMsg, errorMsg);
			 Thread.sleep(3000);
			 WebElement backToLogin=dr.findElement(By.linkText("Back to Login"));
			 backToLogin.click();
			 Thread.sleep(5000);
		 }
		 
		@AfterMethod
		
			public void closeBrowser(){
			dr.close();
		}


	}

	


