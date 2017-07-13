package com.testing.Cliniops;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Cliniops_AutomationScriptsTest extends Cliniops_ReusableMethodsTest{

WebDriver dr;

	//@BeforeTest
    @BeforeMethod
	@Parameters({"browser"})
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
	public void loginErrorMessage1() throws IOException, InterruptedException{
		System.out.println("check1.....");
		//dr = new FirefoxDriver();
		
		dr.get("https://bridgetherapeutics.cliniops.com");
		Thread.sleep(3000);
		
		
		
		WebElement username= dr.findElement(By.id("username"));
		enterText(username, "Abhishek", "Username field");
		
		WebElement pwd= dr.findElement(By.id("password"));
		enterText(pwd, "welcome", "Password field");
		
		WebElement authBtn= dr.findElement(By.id("Authenticate"));
		clickObj(authBtn, "Authenticate Button");
		
		//WebElement errorObj=dr.findElement(By.className("error"));
		WebElement errorObj=dr.findElement(By.xpath(".//*[@id='role']/label[1]"));
		String error= errorObj.getText();
		String expectedText="Authenitcation failed !";
		
		validateMsg(errorObj, expectedText, error);
	
	}
	@Test
	public void sucessFulLogin1() throws IOException, InterruptedException{
		
		//dr = new FirefoxDriver();
		
		dr.get("https://bridgetherapeutics.cliniops.com");
		
		//dr.manage().window().maximize();
		
		WebElement username= dr.findElement(By.id("username"));
		enterText(username, "Abhishek", "Username field");
		
		WebElement pwd= dr.findElement(By.id("password"));
		enterText(pwd, "Welcome123#", "Password field");
		Thread.sleep(5000);
		
		WebElement authBtn= dr.findElement(By.id("Authenticate"));
		clickObj(authBtn, "Authenticate Button");
		Thread.sleep(10000);
		
		
		WebElement dd1=dr.findElement(By.id("investigator_study"));
		//dropDown(dd1, 0);
		Select sel1 = new Select(dd1);
		sel1.selectByVisibleText("Cisplatin/Etoposide/Rad................-Small Cell Lung Cancer");
		Thread.sleep(5000);
		
		WebElement dd2=dr.findElement(By.name("lang_type"));
		Select select = new Select(dd2);
		select.selectByValue("1");
		
		Thread.sleep(10000);

		dr.findElement(By.xpath(".//*[@id='login']//input[@title='Login']")).click();
		System.out.println("logged in successfully");
		
		//verifying login page 
		String actual = dr.findElement(By.xpath(".//*[@id='header-right']/div/span")).getText();
		String expected = "Cisplatin/Etoposide/Radio...Small Cell Lung Cancer";
		if(actual.equals(expected)){
			System.out.println("logged in successfully....");
		}
		else{
			System.out.println("failed to logged in......");
		}

}
		 @Test //(priority = 2)
		 public void loginErrorMessage2() throws IOException, InterruptedException{
			// dr = new FirefoxDriver();
		  
		  dr.get("https://bridgetherapeutics.cliniops.com");
			//dr.manage().window().maximize();
		  
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
		 
		 
		 @Test //(priority = 3)
		 public void loginErrorMessage3() throws IOException, InterruptedException{
			 
			// dr = new FirefoxDriver();
		  dr.get("https://bridgetherapeutics.cliniops.com");
			//dr.manage().window().maximize();
		  
		  WebElement username= dr.findElement(By.id("username"));
		  enterText(username, "Abhishek", "Username field");
		  
		  WebElement pwd= dr.findElement(By.id("password"));
		  enterText(pwd, "", "Password field");
		  Thread.sleep(4000);
		  WebElement authBtn= dr.findElement(By.id("Authenticate"));
		  clickObj(authBtn, "Authenticate Button");
		  //WebElement usererrorMsg=dr.findElement(By.xpath("//*[text()='Please enter the username']"));
		  
		  WebElement pwderrorMsg=dr.findElement(By.xpath("//*[@id='login']/div[2]/label"));
		  String error2= pwderrorMsg.getText();
		  String expectedText2="Please enter the password";
		  validateMsg(pwderrorMsg, expectedText2, error2);
		  Thread.sleep(3000);
		 }
		 
		 @Test // (priority = 4)
		 public void forgotPassword() throws IOException, InterruptedException{
			 
			// dr = new FirefoxDriver();
			 dr.get("https://bridgetherapeutics.cliniops.com");
			// dr.manage().window().maximize();
			 
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

	


