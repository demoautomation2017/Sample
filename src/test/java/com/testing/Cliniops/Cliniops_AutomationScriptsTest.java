package com.testing.Cliniops;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Cliniops_AutomationScriptsTest extends Cliniops_ReusableMethodsTest{

WebDriver dr;  
    
	
    @BeforeMethod    
	@Parameters({"browser"})
	public void selectBrowser(String browser){
		if(browser.equalsIgnoreCase("firefox")){
			dr=new FirefoxDriver();	
			dr.manage().window().maximize();

		}
		else if(browser.equalsIgnoreCase("chrome")){
		
			dr=new ChromeDriver();
			dr.manage().window().maximize();

		}
		else if(browser.equalsIgnoreCase("IE")){

			dr=new InternetExplorerDriver();
	        dr.manage().window().maximize();
	        
		}
		
	}
	
		 @Test
		 	public void auto_clini_login_001() throws Exception{
			 		Actions tooltip;
			 		dr.get("https://bridgetherapeutics.cliniops.com");
			 		tooltip = new Actions(dr);
			 		
			 		WebElement usrname=dr.findElement(By.id("username"));
			 		Thread.sleep(3000);			 		
			 		tooltip.moveToElement(usrname).build().perform();			 		
			 		validateMsg_Attribute(usrname, "Enter Username", "username tooltip", "title");
			 		
			 		WebElement password=dr.findElement(By.id("password"));
			 		Thread.sleep(3000);
			 		tooltip.moveToElement(password).build().perform();
			 		Thread.sleep(3000);			 		
			 		validateMsg_Attribute(password, "Enter Password", "password tooltip", "title");
			 
			 		WebElement authenticate=dr.findElement(By.id("Authenticate"));
			 		Thread.sleep(3000);
			 		tooltip.moveToElement(authenticate).build().perform();
			 		Thread.sleep(3000);			 		
			 		
			 		validateMsg_Attribute(authenticate, "Authenticate", "Authenticate tooltip", "title");

			 		
			 		Thread.sleep(2000);		
					WebElement selectStudy=dr.findElement(By.id("investigator_study"));
					Thread.sleep(2000);		
					tooltip.moveToElement(selectStudy).build().perform();
					Thread.sleep(2000);
					validateMsg_Attribute(selectStudy, "Select Study", "select Study tooltip", "title");
					//TooltipValidation(selectStudy, expectedTooltipText, actualTooltipText);
			 		
			 		WebElement selectLang=dr.findElement(By.id("lang_type"));
			 		Thread.sleep(3000);
			 		tooltip = new Actions(dr);
			 		tooltip.moveToElement(authenticate).build().perform();
			 		Thread.sleep(3000); 				 		
			 		validateMsg_Attribute(selectLang, "Select Language", "select Lang tooltip", "title");
			 
			 		WebElement loginBtn=dr.findElement(By.xpath(".//*[@id='login']/div[7]/input"));
			 		Thread.sleep(5000);
			 		tooltip = new Actions(dr);
			 		tooltip.moveToElement(loginBtn).build().perform();
			 		Thread.sleep(3000);			 		
			 		validateMsg_Attribute(loginBtn, "Login", "login tooltip ", "title");
			 		

		 	}
		 
		  
		 @Test
		 public void auto_clini_login_003() throws IOException, InterruptedException{
			//validating Authentication error message
			    String expected = "Authenitcation failed !";
				dr.get("https://bridgetherapeutics.cliniops.com");
				WebElement userNameObj = dr.findElement(By.xpath(".//*[@id='username']"));
				enterText(userNameObj, "Abhi", "userName object","Enter Username");

				WebElement passwordObj = dr.findElement(By.id("password"));
				enterText(passwordObj, "xxx", "password object","Enter Password");

				//WebElement authenticateObj = dr.findElement(By.id("Authenticate"));
				WebElement authenticateObj = dr.findElement(By.xpath(".//*[@id='Authenticate']"));
				clickElement(authenticateObj, "Authentication button object","Click Authenticate");

				WebElement errMessageObj = dr.findElement(By.xpath(".//*[@id='showCustomErrMsg']"));

				WebDriverWait wait = new WebDriverWait(dr, 30);
				WebElement ele = wait.until(ExpectedConditions.visibilityOf(errMessageObj));
				String actual = ele.getText();
				System.out.println(actual);
				
				if (actual.equals(expected))
				{
					System.out.println("authentication error message is passed");
				}
				else 
				{
					System.out.println("Nothing to check... ");
				}
				
				
				//Testing select study/ select language and login buttons are disabled
				WebElement selStudyObj = dr.findElement(By.xpath(".//*[@id='investigator_study']"));
				if (selStudyObj.isEnabled()){
					System.out.println("selectstudy is enabled...");
				}
				else 
				{
					System.out.println("select study is disabled...");
				}
				
				WebElement selLangObj = dr.findElement(By.xpath(".//*[@id='lang_type']"));
				if (selStudyObj.isEnabled()){
					System.out.println("select language type is enabled...");
				}
				else 
				{
					System.out.println("select language type is disabled...");
				}
				
				WebElement loginObj = dr.findElement(By.xpath(".//*[@id='login']/div[7]/input"));
				if (loginObj.isEnabled()){
					System.out.println("login button is enabled ...");
				}
				else 
				{
					System.out.println("login button is disabled...");
				}

				//Testing for the error messages if we enter incorrect password and username
				WebElement userNameObj1 = dr.findElement(By.xpath(".//*[@id='username']"));
				userNameObj1.clear();
				enterText(userNameObj1, "", "username object","Enter Username");
				WebElement passwordObj1 = dr.findElement(By.id("password"));
				passwordObj1.clear();

				WebElement authenticateObj1 = dr.findElement(By.id("Authenticate"));
				clickElement(authenticateObj1, "Authentication button object","Click Authenticate");
				
				String expUserNameErrMsg = "Please enter the username";
				String expPassWordErrMsg = "Please enter the password";
				
				WebElement unErrObj = dr.findElement(By.xpath(".//*[@id='login']/div[1]/label"));
				String unActual = unErrObj.getText();
				if(expUserNameErrMsg.equals(unActual))
				{
					System.out.println("UserName error message is present...");
				}
				else 
				{
					System.out.println("UserName error message is not present...");
				}
				
				WebElement pwErrObj = dr.findElement(By.xpath(".//*[@id='login']/div[2]/label"));
				String pwActual = pwErrObj.getText();
				
				if(expPassWordErrMsg.equals(pwActual))
				{
					System.out.println("Password error message is present...");
				}
				else 
				{
					System.out.println("Password error message is not present...");
				}

		 }
		 
		 @Test(enabled=false)
		 public void auto_clini_login_004() throws IOException{
			 String errorMsg;
				String expectedErrorMsg;
				dr.get("https://bridgetherapeutics.cliniops.com/login");
				
				WebElement forgotPwd=dr.findElement(By.linkText("Forgot password..? Click here..."));
				clickElement(forgotPwd, "Click Forgot Password", "Forgot Password");
				//Thread.sleep(3000);
				
				WebElement email=dr.findElement(By.id("forgotemail"));
				enterText(email, "abc@gmail.com", "Email id", "Enter Email");
				//Thread.sleep(3000);
				
				WebElement requestNewPwd=dr.findElement(By.id("req_new_pass"));
				clickElement(requestNewPwd, "Click Request Password", "Request new password");
				//Thread.sleep(3000);
				
				//WebElement emailIdError=dr.findElement(By.xpath("//*[text()='Email-id does not exist in database.']"));
				WebElement emailIdError = (new WebDriverWait(dr, 5))
						.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[text()='Email-id does not exist in database.']")));
				errorMsg=emailIdError.getText();
				expectedErrorMsg="Email-id does not exist in database.";
				validateText(emailIdError, expectedErrorMsg, errorMsg,"Email error");
				//Thread.sleep(3000);
				
				WebElement email2=dr.findElement(By.id("forgotemail"));
				enterText(email2, "abhishekmj11@gmail.com", "Email id", "Enter Email");
				//Thread.sleep(3000);
				
				WebElement requestNewPwd2=dr.findElement(By.id("req_new_pass"));
				clickElement(requestNewPwd2, "Click Request Password", "Request new password");
				//Thread.sleep(3000);
				
				WebElement emailIdError2=dr.findElement(By.xpath(".//*[@id='content-body']/div[1]/span"));
				errorMsg=emailIdError2.getText();
				expectedErrorMsg="Email has been sent to your email address. Please check to create your new password.";
				validateText(emailIdError2, expectedErrorMsg, errorMsg,"Email error");
		 }
		 @Test

		 public void auto_clini_login_005() throws Exception{
			 dr.get("https://bridgetherapeutics.cliniops.com");
			 WebElement rightFooter=dr.findElement(By.id("footer-right"));
			 validateText(rightFooter, "Version : 2.0.27", "Right Footer:Version 2.0.27 ","Right Footer");
			 WebElement logo=dr.findElement(By.xpath(".//*[@id='logo']/h1/a/img"));
			 if(logo.isDisplayed()){
				 Update_Report("Pass", "Presence of Logo", "Logo appears");
			 }
			 else{
				 Update_Report("Fail", "Presence of Logo", "Logo not displayed");
			 }
		 }


		@AfterMethod
		
			public void closeBrowser(){
			dr.close();
		}


	}

	


