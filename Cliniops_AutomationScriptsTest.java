package com.testing.Cliniops;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class Cliniops_AutomationScriptsTest extends Cliniops_ReusableMethodsTest{

WebDriver dr= new FireFoxDriver();

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
	public void login() throws InterruptedException{
		
		dr.get("https://bridgetherapeutics.cliniops.com");
		
		WebElement userName = dr.findElement(By.id("username"));
		enterText( userName , "Abhishek" , "Username field");
		
		WebElement password = dr.findElement(By.id("password"));
		enterText( password , "Welcome123#" , "password field");
		
		Thread.sleep(4000);
		
		WebElement authButton = dr.findElement(By.id("Authenticate"));
		clickObj( authButton ,"Authenticate Button");
		
		WebElement dd = dr.findElement(By.id("investigator_study"));
		Thread.sleep(10000);
		Select select = new Select(dd);
		select.selectByVisibleText("Cisplatin/Etoposide/Rad................-Small Cell Lung Cancer");
		
		WebElement dd2 = dr.findElement(By.id("lang_type"));
		Thread.sleep(10000);
		Select sel2  = new Select(dd2);
		Thread.sleep(15000);
		sel2.selectByValue("1");
		
		WebElement loginBtn = dr.findElement(By.xpath(".//*[@id='login']//input[@title='Login']"));
		clickObj ( loginBtn , "LoginButton");
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
		//dr.close();
		
	}
	
	@AfterMethod
	
		public void closeBrowser(){
		dr.close();
	}

	public void loginErrorMessage1() throws IOException{
		
		dr.get("https://bridgetherapeutics.cliniops.com");
		
		WebElement username= dr.findElement(By.id("username"));
		enterText(username, "Abhishek", "Username field");
		
		WebElement pwd= dr.findElement(By.id("password"));
		enterText(pwd, "welcome", "Password field");
		
		WebElement authBtn= dr.findElement(By.id("Authenticate"));
		clickObj(authBtn, "Authenticate Button");
		
		
		WebElement dd1=dr.findElement(By.id("investigator_study"));
		dropDown(dd1, 0);

		WebElement dd2=dr.findElement(By.name("lang_type"));
		Select select = new Select(dd2);
		//dropDown(dd2, 0);
		select.selectByValue("1");
		
		WebElement clickLogin= dr.findElement(By.className("login-btnew disable"));
		clickObj(clickLogin, "Login");


}
