package com.testing.Cliniops;

public class Cliniops_AutomationScriptsTest extends Cliniops_ReusableMethodsTest{

WebDriver dr;

	@BeforeTest
	@Parameters("browser")
	public void Selectbrowser(String browser){
		if(browser.equalsIgnoreCase("firefox")){
			System.setProperty("webdriver.firefox.marionette", "C:/Users/Zunaira's/Documents/QA automation/geckodriver-v0.16.1-win64/geckodriver.exe");
			dr=new FirefoxDriver();	
			dr.manage().window().maximize();

		}
		else if(browser.equalsIgnoreCase("chrome")){
			System.setProperty("webdriver.chrome.driver", "C:/Users/Zunaira's/Documents/QA automation/chromedriver.exe");
			dr=new ChromeDriver();

		}
		else if(browser.equalsIgnoreCase("IE")){
			System.setProperty("webdriver.ie.driver", "C:/Users/Zunaira's/Documents/QA automation/IEDriverServer.exe");
	        dr=new InternetExplorerDriver();
		}
		dr.manage().window().maximize();
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
