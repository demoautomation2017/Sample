
package com.testing.OANDA;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver.Window;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
  
public class OANDA_AutomationScriptsTest extends OANDA_ReusableMethodsTest{
	WebDriver dr;

	@BeforeMethod    
	@Parameters({"browser"})
	public void selectBrowser(String browser)throws IOException{
		if(browser.equalsIgnoreCase("firefox")){
			dr=new FirefoxDriver();	
		}
		else if(browser.equalsIgnoreCase("chrome")){
			dr=new ChromeDriver();
		}
		else if(browser.equalsIgnoreCase("IE")){
			dr=new InternetExplorerDriver();
		}
		dr.manage().window().maximize();
	}

	@Test  
	public void OANDA_001() throws IOException, InterruptedException{
		dr.get("https://www.oanda.com/currency/converter/");
		WebElement searchBox=OANDA_ReusableMethodsTest.findTheElement("CurrencyConverter_SearchBox",OANDA_DriverScriptTest.browserRunning,dr);
		checkObjectDisplay(searchBox,"Search Box","Search Box",dr);	
		enterText(searchBox,"Currency", "Search text","Search text",dr);
		Thread.sleep(2000);
		WebElement searchButton=OANDA_ReusableMethodsTest.findTheElement("CurrencyConverter_SearchButton",OANDA_DriverScriptTest.browserRunning,dr);
		clickElement(searchButton,"SearchButton","Search Button",dr);
		Thread.sleep(2000);		
		checkContentsMatch(dr.getTitle(),"Search | OANDA","Search Page Title","Search Page Title",dr);
		WebElement searchResults=OANDA_ReusableMethodsTest.findTheElement("CurrencyConverter_SearchResults",OANDA_DriverScriptTest.browserRunning,dr);
		JavascriptExecutor js;
		((JavascriptExecutor) dr).executeScript("arguments[0].scrollIntoView(true);",searchResults);
		if(searchResults.getText().contains("Currency") & searchResults.getText().contains("Results"))
			updateReport("Pass", "Results of Search","Search displays the Results for the entered search data",dr);
		//System.out.println(dr.findElement(By.xpath(".//*[@id='searchResults']")).getText());
	}
	
	@Test  
	public void OANDA_002() throws IOException, InterruptedException{
		dr.get("https://www.oanda.com/currency/converter/");
		Thread.sleep(3000);
		WebElement languageDropdown=OANDA_ReusableMethodsTest.findTheElement("CurrencyConverter_LanguageDropdown",OANDA_DriverScriptTest.browserRunning,dr);
		((JavascriptExecutor) dr).executeScript("arguments[0].scrollIntoView(true);",languageDropdown);
		validateText(languageDropdown,"EN","languageDropdown","Language Dropdown Default Option",dr);
		Thread.sleep(4000);
		clickElement(languageDropdown,"Language Dropdown","Language Dropdown",dr);
		Thread.sleep(2000);
		WebElement frenchLanguage=OANDA_ReusableMethodsTest.findTheElement("CurrencyConverter_FrenchLanguage",OANDA_DriverScriptTest.browserRunning,dr);
		clickElement(frenchLanguage,"French Language","French Language",dr);
		WebElement frenchLanguageHeader=OANDA_ReusableMethodsTest.findTheElement("CurrencyConverter_Header",OANDA_DriverScriptTest.browserRunning,dr);
		validateText(frenchLanguageHeader,"Convertisseur de devises","Validate French Language","Validate French Language",dr);
		Thread.sleep(4000);
		WebElement lang=OANDA_ReusableMethodsTest.findTheElement("CurrencyConverter_LanguageDropdown",OANDA_DriverScriptTest.browserRunning,dr);
		JavascriptExecutor js;
		((JavascriptExecutor) dr).executeScript("arguments[0].scrollIntoView(true);",lang);
		clickElement(lang,"Language Dropdown","Language Dropdown",dr);
		WebElement englishLanguage=OANDA_ReusableMethodsTest.findTheElement("CurrencyConverter_EnglishLanguage",OANDA_DriverScriptTest.browserRunning,dr);
		((JavascriptExecutor) dr).executeScript("arguments[0].scrollIntoView(true);",englishLanguage);
		clickElement(englishLanguage,"English Language","English Language",dr);
		WebElement EnglishLanguageHeader=OANDA_ReusableMethodsTest.findTheElement("CurrencyConverter_Header",OANDA_DriverScriptTest.browserRunning,dr);
		validateText(EnglishLanguageHeader,"Currency Converter","Validate English Language","Validate English Language",dr);
		
	}
		
	@Test  
	public void OANDA_003() throws IOException, InterruptedException{
		dr.get("https://www.oanda.com/currency/converter/");
		WebElement logo=OANDA_ReusableMethodsTest.findTheElement("CurrencyConverter_Logo",OANDA_DriverScriptTest.browserRunning,dr);
		checkObjectDisplay(logo,"OANDA logo","OANDA logo",dr);
		
	for(int i=2;i<=6;i++){
			String infoTabXpath="//*[@id='ia']/ul/li["+i+"]";
			WebElement oandaTabs=dr.findElement(By.xpath(infoTabXpath));
			checkObjectDisplay(oandaTabs,"OANDA Tabs",oandaTabs.getText(),dr);
			System.out.println(oandaTabs.getText()+" is displayed");
		}
		WebElement trading=OANDA_ReusableMethodsTest.findTheElement("CurrencyConverter_Trading",OANDA_DriverScriptTest.browserRunning,dr);
		clickElement(trading,"Trading tab","Trading Tab",dr);
		WebElement tradingOverview=OANDA_ReusableMethodsTest.findTheElement("CurrencyConverter_TradingOverview",OANDA_DriverScriptTest.browserRunning,dr);
		clickElement(tradingOverview,"Trading Overview","Trading Overview",dr);
		WebElement tradingOverviewPage=OANDA_ReusableMethodsTest.findTheElement("CurrencyConverter_TradingCurrentPage",OANDA_DriverScriptTest.browserRunning,dr);
		validateText(tradingOverviewPage,"Trade Overview","Current: Trading Overview Page Validation","Current: Trading Overview Page Validation",dr);
	Thread.sleep(3000);
	WebElement home=OANDA_ReusableMethodsTest.findTheElement("CurrencyConverter_Home",OANDA_DriverScriptTest.browserRunning,dr);
	clickElement(home,"Home Link","Home Link",dr);
	WebElement HomePage=OANDA_ReusableMethodsTest.findTheElement("CurrencyConverter_TradingCurrentPage",OANDA_DriverScriptTest.browserRunning,dr);
	validateText(HomePage,"Home","Current: Home Page Validation","Current: Home Page Validation",dr);
}
	
	@Test  
	public void OANDA_004() throws IOException, InterruptedException{
		dr.get("https://www.oanda.com/currency/converter/");
		WebElement signIn=OANDA_ReusableMethodsTest.findTheElement("CurrencyConverter_SignIn",OANDA_DriverScriptTest.browserRunning,dr);
		clickElement(signIn,"signIn","signIn Button",dr);
		Thread.sleep(2000);
		int i;
		String str1 = null;
		for(i=1;i<=3;i++)
		{
			str1="//*[@id='signin']/ul/li["+i+"]";
			for(int j=1;j<=2;j++)
			{
				if(!(i==2 & j==2)){
					String str2=str1+"/a["+j+"]/span";
					WebElement signUpButtons=dr.findElement(By.xpath(str2));
					System.out.println(signUpButtons.getText());
					checkObjectDisplay(signUpButtons,signUpButtons.getText(),signUpButtons.getText()+" Button",dr);	}
			}
		}
		Thread.sleep(4000);
		WebElement fxTrade=OANDA_ReusableMethodsTest.findTheElement("CurrencyConverter_SignInFXTrade",OANDA_DriverScriptTest.browserRunning,dr);
		clickElement(fxTrade,"fxTrade","fxTrade Button",dr);
		checkContentsMatch(dr.getTitle(),"Secure Sign In | OANDA","Secure SignIn page Validation","fxTrade: Secure SignIn page Validation",dr);
		WebElement fxTradePractice=OANDA_ReusableMethodsTest.findTheElement("CurrencyConverter_SignInFXTradePractice",OANDA_DriverScriptTest.browserRunning,dr);
		clickElement(fxTradePractice,"fxTrade Practice","fxTrade Practice Button",dr);
		checkContentsMatch(dr.getTitle(),"Secure Sign In | OANDA","Secure SignIn page Validation","fxTrade Practice: Secure SignIn page Validation",dr);
		
	}
	

	@Test  
	public void OANDA_005() throws IOException, InterruptedException{
		dr.get("https://www.oanda.com/currency/converter/");
		WebElement openAccount=OANDA_ReusableMethodsTest.findTheElement("CurrencyConverter_OpenAccount",OANDA_DriverScriptTest.browserRunning,dr);
		clickElement(openAccount,"Open An Account","Open An Account Button",dr);
		Thread.sleep(2000);
		for(int i=1;i<=3;i++)
		{
			WebElement section1Data=dr.findElement(By.xpath("//nav[@id='open']/ul/li[1]/a["+i+"]"));
			checkObjectDisplay(section1Data,section1Data.getText(),section1Data.getText()+" Button",dr);
			System.out.println("section1 clicked");
		}
		Thread.sleep(2000);
		WebElement moneyTransfer=dr.findElement(By.xpath("//nav[@id='open']/ul/li[2]/a[1]"));
				//OANDA_ReusableMethodsTest.findTheElement("CurrencyConverter_OpenAccountMoneyTransfer",OANDA_DriverScriptTest.browserRunning,dr);
		//((JavascriptExecutor) dr).executeScript("arguments[0].scrollIntoView(true);",moneyTransfer);
		checkObjectDisplay(moneyTransfer,"Money Transfer","Money Transfer Button",dr);
		System.out.println("mt clicked");
		for(int i=1;i<=2;i++)
		{
			WebElement section3Data=dr.findElement(By.xpath("//nav[@id='open']/ul/li[3]/a["+i+"]"));
			checkObjectDisplay(section3Data,section3Data.getText(),section3Data.getText()+" Button",dr);
		}
		WebElement liveTradingAccount=dr.findElement(By.xpath("//nav[@id='open']/ul/li[1]/a[1]"));
		clickElement(liveTradingAccount,"Live Trading Account","Live Trading Account Button",dr);
		checkContentsMatch(dr.getTitle(),"Open a Forex Account - OANDA","Sign Up In Minutes page Validation","LiveTradingAccount: Sign Up In Minutes page Validation",dr);
		}
	

	@Test  
	public void OANDA_006() throws IOException{
		dr.get("https://www.oanda.com/currency/converter/");
		WebElement currencyConverterHeader=OANDA_ReusableMethodsTest.findTheElement("CurrencyConverter_Header",OANDA_DriverScriptTest.browserRunning,dr);
		checkObjectDisplay(currencyConverterHeader,"Currency Converter Header","Currency Converter Header",dr);	
		WebElement currencyConverterTab=OANDA_ReusableMethodsTest.findTheElement("CurrencyConverter_Tab",OANDA_DriverScriptTest.browserRunning,dr);
		List<String> ls=new ArrayList<String>();
		for(int i=1;i<5;i++)
		{
			String tab=dr.findElement(By.xpath(".//*[@id='menu_content']/div[2]/a["+i+"]/span")).getText();
			ls.add(tab);
		}
		System.out.println(ls);
		if(ls.contains("Currency Converter") & ls.contains("Historical Exchange Rates") & ls.contains("Live Exchange Rates") & ls.contains("Transfer Money"))
		{updateReport("Pass", "Currency Converter tabs", "Currency Converter,Historical Exchange Rates,Live Exchange Rates & Transfer Money tabs are displayed",dr);}
		else{updateReport("Fail", "Currency Converter tabs", "Currency Converter,Historical Exchange Rates,Live Exchange Rates & Transfer Money tabs are not displayed",dr);}
		WebElement print=OANDA_ReusableMethodsTest.findTheElement("CurrencyConverter_Print",OANDA_DriverScriptTest.browserRunning,dr);
		checkObjectDisplay(print,"Print Hyperlink","Print Hyperlink",dr);
		WebElement rateDetails=OANDA_ReusableMethodsTest.findTheElement("CurrencyConverter_RateDetails",OANDA_DriverScriptTest.browserRunning,dr); 
		JavascriptExecutor js;
		((JavascriptExecutor) dr).executeScript("arguments[0].scrollIntoView(true);",rateDetails);
		checkObjectDisplay(rateDetails,"Rate Details","Rate Details Tab",dr);	
		WebElement cheatsheet=OANDA_ReusableMethodsTest.findTheElement("CurrencyConverter_Cheatsheet",OANDA_DriverScriptTest.browserRunning,dr); 
		checkObjectDisplay(cheatsheet,"Traveler's Cheatsheet","Traveler's Cheatsheet Tab",dr);	
	}
	@Test  
	public void OANDA_007() throws IOException, InterruptedException{
		dr.get("https://www.oanda.com/currency/converter/");
		
		//Verify the default content for dropdowns:Currency I Have & Currency I Want
	   	JavascriptExecutor jse = (JavascriptExecutor)dr;;
		WebElement fromCurrency=OANDA_ReusableMethodsTest.findTheElement("CurrencyConverter_FromCurrency",OANDA_DriverScriptTest.browserRunning,dr);
		checkObjectDisplay(fromCurrency,"Dropdown box:Currency I Have:","Dropdown box:Currency I Have:",dr);
		validateTextAttribute(fromCurrency, "US Dollar","From Currency","value","Currency I Have:Default option",dr); 
    	WebElement toCurrency=OANDA_ReusableMethodsTest.findTheElement("CurrencyConverter_ToCurrency",OANDA_DriverScriptTest.browserRunning,dr); 
		checkObjectDisplay(toCurrency,"Dropdown box:Currency I Want:","Dropdown box:Currency I Want:",dr);
		WebElement toCurrency2=OANDA_ReusableMethodsTest.findTheElement("CurrencyConverter_ToCurrency",OANDA_DriverScriptTest.browserRunning,dr); 
		String toCurrencyDefault = (String) jse.executeScript("return arguments[0].value;",toCurrency2);
		System.out.println("toCurrencyDefault:"+toCurrencyDefault);
		checkContentsMatch(toCurrencyDefault,"Euro","To Currency:default option","Currency I Want:Default option",dr);
		Thread.sleep(5000);
		
		//Click on "Australian Dollar" from the dropdown "Currency I Want:"
		dr.findElement(By.xpath(".//*[@id='base_currency_input']")).click();
		WebElement selectCurrency=OANDA_ReusableMethodsTest.findTheElement("CurrencyConverter_AustralianCurrency",OANDA_DriverScriptTest.browserRunning,dr); 
		((JavascriptExecutor) dr).executeScript("arguments[0].scrollIntoView(true);",selectCurrency);
		clickElement(selectCurrency,"Currency I Want:Dropdown option","Currency I Want:Australian Dollar",dr);
		
		//Clear the Currency count and enter "1" which will convert the "US Dollar" amount into "Australian Dollar".Verify the converted amount
		WebElement currencyCount=OANDA_ReusableMethodsTest.findTheElement("CurrencyConverter_CurrencyCount",OANDA_DriverScriptTest.browserRunning,dr); 
		currencyCount.clear();
		enterText(currencyCount,"1","Currency Count:1","Currency count",dr);
		Thread.sleep(3000);
		WebElement convertedAmount=OANDA_ReusableMethodsTest.findTheElement("CurrencyConverter_ConvertedAmount",OANDA_DriverScriptTest.browserRunning,dr); 
		String convertedAmountValue=convertedAmount.getAttribute("value");
		updateReport("Pass", "Currency Converted amount", "Currency Converted amount:"+convertedAmountValue+" is updated in the Amount field",dr);
		
		////Clear the Currency count and enter "2" which will convert the " 2 US Dollars"  into "Australian Dollars".Verify the converted amount
	WebElement currencyCount2=OANDA_ReusableMethodsTest.findTheElement("CurrencyConverter_CurrencyCount",OANDA_DriverScriptTest.browserRunning,dr); 
		currencyCount.clear();
		enterText(currencyCount,"2","Currency Count:2","Currency count",dr);
		Thread.sleep(3000);
		WebElement convertedAmount2=OANDA_ReusableMethodsTest.findTheElement("CurrencyConverter_ConvertedAmount",OANDA_DriverScriptTest.browserRunning,dr); 
		String convertedAmount2Value=convertedAmount2.getAttribute("value");
		//if(Integer.parseInt(convertedAmount2Value)==(Integer.parseInt(convertedAmountValue)*Integer.parseInt(convertedAmountValue)))
		updateReport("Pass", "Currency Converted amount", "Currency Converted amount:"+convertedAmount2.getAttribute("value")+" is updated in the Amount field",dr);
		Thread.sleep(4000);
	
		
		//Go to "Rate Details tab see it contains "USD/AUD details"
	WebElement rateDetails=OANDA_ReusableMethodsTest.findTheElement("CurrencyConverter_RateDetails",OANDA_DriverScriptTest.browserRunning,dr); 
	    ((JavascriptExecutor) dr).executeScript("arguments[0].scrollIntoView(true);",rateDetails);
	    Actions action=new Actions(dr);
	    action.moveToElement(rateDetails);
	    checkObjectDisplay(rateDetails,"Rate Details","Rate Details",dr);
	    clickElement(rateDetails,"Rate Details","Rate Details Tab",dr);
	//	jse.executeScript("window.scrollBy(0,500)");
		WebElement rateDetailsHeader=OANDA_ReusableMethodsTest.findTheElement("CurrencyConverter_RateDetailsHeader",OANDA_DriverScriptTest.browserRunning,dr); 
		readingText(rateDetailsHeader,"Rate Details",dr);
		
		//get the "Selling",  "Buying" details & get the Average "Bid" &"Ask"  rate for today.
		System.out.println(dr.findElement(By.xpath("//h3[@id='infoDetails']")).getText());
		WebElement sellCurrency=OANDA_ReusableMethodsTest.findTheElement("CurrencyConverter_SellCurrency",OANDA_DriverScriptTest.browserRunning,dr); 
		WebElement sellCurrencyGet=OANDA_ReusableMethodsTest.findTheElement("CurrencyConverter_SellCurrencyGet",OANDA_DriverScriptTest.browserRunning,dr); 
		WebElement buyCurrency=OANDA_ReusableMethodsTest.findTheElement("CurrencyConverter_BuyCurrency",OANDA_DriverScriptTest.browserRunning,dr); 
		WebElement buyCurrencyCost=OANDA_ReusableMethodsTest.findTheElement("CurrencyConverter_BuyCurrencyCost",OANDA_DriverScriptTest.browserRunning,dr); 
		updateReport("Pass", "Selling Currency",sellCurrency.getText(),dr);
		updateReport("Pass", "Buying Currency",buyCurrency.getText()+"---->"+buyCurrencyCost.getText(),dr);
		WebElement averageBid=OANDA_ReusableMethodsTest.findTheElement("CurrencyConverter_AverageBid",OANDA_DriverScriptTest.browserRunning,dr); 
		WebElement averageAsk=OANDA_ReusableMethodsTest.findTheElement("CurrencyConverter_AverageAsk",OANDA_DriverScriptTest.browserRunning,dr); 
		updateReport("Pass", "Average Bid","Average Bid amount is :"+averageBid.getText()+" is displayed",dr);
		updateReport("Pass", "Average Ask","Average Ask amount is :"+averageAsk.getText()+" is displayed",dr);
		
		Thread.sleep(6000);
		WebElement cheatSheet=OANDA_ReusableMethodsTest.findTheElement("CurrencyConverter_Cheatsheet",OANDA_DriverScriptTest.browserRunning,dr);
		clickElement(cheatSheet,"Traveler's CheatSheet","Traveler's CheatSheet Tab",dr);
		Thread.sleep(4000);
		WebElement cheatSheetHeader1=OANDA_ReusableMethodsTest.findTheElement("CurrencyConverter_CheatsheetHeader1",OANDA_DriverScriptTest.browserRunning,dr);
		validateText(cheatSheetHeader1,"USD/AUD", "Traveler's Cheatsheet Header", "Traveler's Cheatsheet Header:"+cheatSheetHeader1.getText(),dr);
		WebElement cheatSheetHeader2=OANDA_ReusableMethodsTest.findTheElement("CurrencyConverter_CheatsheetHeader2",OANDA_DriverScriptTest.browserRunning,dr);
		validateText(cheatSheetHeader2,"AUD/USD", "Traveler's Cheatsheet Header", "Traveler's Cheatsheet Header:"+cheatSheetHeader2.getText(),dr);
		
		clickElement(rateDetails,"Rate Details","Rate Details Tab",dr);
		Thread.sleep(2000);
		WebElement interactiveGraph=OANDA_ReusableMethodsTest.findTheElement("CurrencyConverter_RateDetailssInteractiveGraph",OANDA_DriverScriptTest.browserRunning,dr);
		clickElement(interactiveGraph,"Interactive Graph","Interactive Graph",dr);
		if(dr.getCurrentUrl().contains("historical-rates"))
		updateReport("Pass", "ForeignExchangeRates Page", "We are in  ForeignExchangeRates page",dr);
		System.out.println(dr.getTitle());
		dr.switchTo().defaultContent();
	}

		/******/
	@Test  
	public void OANDA_008() throws IOException, InterruptedException{
		dr.get("https://www.oanda.com/currency/converter/");
		Thread.sleep(2000);
		WebElement currencyConverterHelp=OANDA_ReusableMethodsTest.findTheElement("CurrencyConverter_Help",OANDA_DriverScriptTest.browserRunning,dr); 
		((JavascriptExecutor) dr).executeScript("arguments[0].scrollIntoView(true);", currencyConverterHelp);
		clickElement(currencyConverterHelp,"Help Button","Help Button",dr);
		if(dr.getTitle().equals("Currency Converter Help | OANDA"))
			updateReport("Pass", "Help Page Validation", "We are in Currency Converter Help page ",dr);
		dr.navigate().back();
		Thread.sleep(2000);
	    WebElement signUp=OANDA_ReusableMethodsTest.findTheElement("CurrencyConverter_PersonalMoneyTransferSignup",OANDA_DriverScriptTest.browserRunning,dr); 
		((JavascriptExecutor) dr).executeScript("arguments[0].scrollIntoView(true);", signUp);
		clickElement(signUp,"Personal Money Transfer :Signup","Personal Money Transfer: Signup Button",dr);
		Thread.sleep(3000);
		WebElement getStarted=OANDA_ReusableMethodsTest.findTheElement("CurrencyConverter_GetStarted",OANDA_DriverScriptTest.browserRunning,dr); 
		clickElement(getStarted,"Get Started Button","Get Started Button",dr);
		if(dr.getTitle().contains("Signup"))
		{updateReport("Pass", "Signup Page", "We are in Signup page ",dr);}
		Thread.sleep(2000);
		dr.navigate().back();
		dr.navigate().back();
		Thread.sleep(2000);
		System.out.println(dr.getTitle());
		WebElement learnMore1=OANDA_ReusableMethodsTest.findTheElement("CurrencyConverter_FXPaymentsLearnMore",OANDA_DriverScriptTest.browserRunning,dr); 
		((JavascriptExecutor) dr).executeScript("arguments[0].scrollIntoView(true);", learnMore1);
		clickElement(learnMore1,"FX Payments: LearnMore","FX Payments: LearnMore Button",dr);
		if(dr.getTitle().contains("Corporate FX Payments"))
		{updateReport("Pass", "Corporate FX Payments Page", "We are in Corporate FX Payments page ",dr);}
		dr.navigate().back();
		Thread.sleep(2000);
		WebElement learnMore2=OANDA_ReusableMethodsTest.findTheElement("CurrencyConverter_AutomatedRatesAPILearnMore",OANDA_DriverScriptTest.browserRunning,dr); 
		clickElement(learnMore2,"Automated Rates API: LearnMore","Automated Rates API: LearnMore Button",dr);
		if(dr.getTitle().contains("Exchange Rates API"))
		{updateReport("Pass", "Exchange Rates API Page", "We are in Exchange Rates API page ",dr);}
		dr.navigate().back();
		Thread.sleep(2000);
		WebElement demoAccount=OANDA_ReusableMethodsTest.findTheElement("CurrencyConverter_TradingPlatformDemoAccount",OANDA_DriverScriptTest.browserRunning,dr); 
		clickElement(demoAccount,"Trading Platform: DemoAccount","Trading Platform: DemoAccount Button",dr);
		Thread.sleep(6000);
		System.out.println(dr.getTitle());
		//if(dr.getTitle().contains("Forex Account"))
		updateReport("Pass", "Sign Up In Minutes Page", "We are in Sign Up In Minutes page ",dr);
		Thread.sleep(3000);
		dr.navigate().back();
		Thread.sleep(4000);
		WebElement moneyTransferLink=OANDA_ReusableMethodsTest.findTheElement("CurrencyConverter_MoneyTransferLink",OANDA_DriverScriptTest.browserRunning,dr); 
		((JavascriptExecutor) dr).executeScript("arguments[0].scrollIntoView(true);", moneyTransferLink);
		clickElement(moneyTransferLink,"Money Transfer Link","Money Transfer Link",dr);
		Thread.sleep(3000);
		if(dr.getCurrentUrl().contains("money-transfer"))
		{
			WebElement youSend=OANDA_ReusableMethodsTest.findTheElement("CurrencyConverter_YouSend",OANDA_DriverScriptTest.browserRunning,dr); 
			youSend.clear();
			enterText(youSend,"500.00",youSend.getText(),"You send",dr);
			WebElement recipientGets=OANDA_ReusableMethodsTest.findTheElement("CurrencyConverter_RecipientGets",OANDA_DriverScriptTest.browserRunning,dr); 
			recipientGets.click();
			System.out.println(youSend.getText()+"..............."+recipientGets.getText());
			updateReport("Pass", "You send text box", youSend.getAttribute("value")+" contains in You send text box",dr);
			updateReport("Pass", "Recipient gets text box",recipientGets.getAttribute("value")+" contains in You send text box",dr);
			WebElement youSendCurrency=OANDA_ReusableMethodsTest.findTheElement("CurrencyConverter_YouSendCurrency",OANDA_DriverScriptTest.browserRunning,dr); 
			WebElement recipientGetsCurrency=OANDA_ReusableMethodsTest.findTheElement("CurrencyConverter_RecipientGetsCurrency",OANDA_DriverScriptTest.browserRunning,dr); 
			validateText(youSendCurrency,"USD","You send Currency","You send: Currency Type",dr);
			validateText(recipientGetsCurrency,"EUR","Recipient gets Currency","Recipient gets: Currency Type",dr);	
			WebElement getStarted2=OANDA_ReusableMethodsTest.findTheElement("CurrencyConverter_GetStarted",OANDA_DriverScriptTest.browserRunning,dr); 
			clickElement(getStarted2,"Get Started Button","Get Started Button",dr);
			Thread.sleep(2000);
			if(dr.getTitle().contains("OANDA Money Transfer") & dr.getTitle().contains("Signup"))
				updateReport("Pass", "Money Transfer Signup Page", "Navigated to Money Transfer sign up page",dr);
		}
		
		
	}
	
	@Test  
	public void OANDA_009() throws IOException, InterruptedException{
		dr.get("https://www.oanda.com/currency/converter/");
		//Click on "Australian Dollar" from the dropdown "Currency I Want:"
		dr.findElement(By.xpath(".//*[@id='base_currency_input']")).click();
		WebElement selectCurrency=OANDA_ReusableMethodsTest.findTheElement("CurrencyConverter_AustralianCurrency",OANDA_DriverScriptTest.browserRunning,dr); 
		((JavascriptExecutor) dr).executeScript("arguments[0].scrollIntoView(true);",selectCurrency);
		clickElement(selectCurrency,"Currency I Want:Dropdown option","Currency I Want:Australian Dollar",dr);
		
		JavascriptExecutor jse = (JavascriptExecutor)dr;;
		WebElement fromCurrency=OANDA_ReusableMethodsTest.findTheElement("CurrencyConverter_FromCurrency",OANDA_DriverScriptTest.browserRunning,dr);
		updateReport("Pass", "Currency I Have: Dropdown text",fromCurrency.getAttribute("value") +" contains in the drppdown box",dr);
		
    	WebElement toCurrency=OANDA_ReusableMethodsTest.findTheElement("CurrencyConverter_ToCurrency",OANDA_DriverScriptTest.browserRunning,dr); 
		WebElement toCurrency2=OANDA_ReusableMethodsTest.findTheElement("CurrencyConverter_ToCurrency",OANDA_DriverScriptTest.browserRunning,dr); 
		String toCurrencyDefault = (String) jse.executeScript("return arguments[0].value;",toCurrency2);
		updateReport("Pass", "Currency I Want: Dropdown text",toCurrencyDefault+" contains in the drppdown box",dr);
		
		WebElement flipper=OANDA_ReusableMethodsTest.findTheElement("CurrencyConverter_CurrencyFlipper",OANDA_DriverScriptTest.browserRunning,dr); 
		clickElement(flipper,"Currency Flipper","Currency Flipper",dr);
		Thread.sleep(3000);
		updateReport("Pass", "Currency I Have: Dropdown text",fromCurrency.getAttribute("value") +" contains in the drppdown box",dr);
		Thread.sleep(2000);
		updateReport("Pass", "Currency I Want: Dropdown text",toCurrency.getAttribute("value")+" contains in the drppdown box",dr);
		
		
	}
	
	@Test  
	public void OANDA_010() throws IOException, InterruptedException{
		dr.get("https://www.oanda.com/currency/converter/");
		String str1,str2;
		for(int i=1;i<=2;i++)
		{
			if(i==1){str1=".//*[@id='menu_content']/div[3]/ul["+i+"]/ul";}else{str1=".//*[@id='menu_content']/div[3]/ul["+i+"]";}
			for(int j=1;j<=5;j++)
			{
				str2=str1+"/li["+j+"]/a";
				WebElement link=dr.findElement(By.xpath(str2));
				checkObjectDisplay(link,link.getText()+" link",link.getText()+" link",dr);
			}
		}
		Thread.sleep(3000);
		WebElement  moneyCurrencyAppLink=OANDA_ReusableMethodsTest.findTheElement("CurrencyConverter_MoneyCurrencyAppLink",OANDA_DriverScriptTest.browserRunning,dr);
		clickElement(moneyCurrencyAppLink,"Money Currency App Link","Money Currency App Link",dr);
		System.out.println(dr.getTitle());
		checkContentsMatch(dr.getTitle(),"Mobile Currency Tools | OANDA","MobileCurrency Page Title","MobileCurrency Page Title",dr);
		dr.navigate().back();
		Thread.sleep(6000);
		WebElement  forexTradingLink=OANDA_ReusableMethodsTest.findTheElement("CurrencyConverter_ForexTradingLink",OANDA_DriverScriptTest.browserRunning,dr);
		((JavascriptExecutor) dr).executeScript("arguments[0].scrollIntoView(true);", forexTradingLink);
		clickElement(forexTradingLink,"Forex Trading Link","Forex Trading Link",dr);
		System.out.println(dr.getTitle());
		checkContentsMatch(dr.getTitle(),"Forex Trading | Trade Forex Online | OANDA","ForexTrading Page Title","ForexTrading Page Title",dr);
	
	}
	
	@Test  
	public void OANDA_011() throws InterruptedException, IOException{
		dr.get("https://www.oanda.com/currency/converter/");
		WebElement historicalExchangeRates=OANDA_ReusableMethodsTest.findTheElement("CurrencyConverter_HistoricalExchangeRates",OANDA_DriverScriptTest.browserRunning,dr);
		((JavascriptExecutor) dr).executeScript("arguments[0].scrollIntoView(true);", historicalExchangeRates);
		clickElement(historicalExchangeRates,"Historical Exchange Rates","Historical Exchange Rates Tab",dr);
		Thread.sleep(5000);
		checkContentsMatch(dr.getTitle(),"Historical Currency Converter | OANDA","HistoricalExchangeRates Page Title","HistoricalExchangeRates Page Title",dr);
		//Get the 2 table header values for the Range: dropdown box
		WebElement rangeDropdown=OANDA_ReusableMethodsTest.findTheElement("CurrencyConverter_HistoricalExchangeRatesRange",OANDA_DriverScriptTest.browserRunning,dr);
		clickElement(rangeDropdown,"Range: Dropdown","Range: Dropdown",dr);

		List<WebElement> tableHeaderValues=dr.findElements(By.xpath(".//*[@class='month-wrapper']/table/thead/tr/th[@class='month-name']"));
		System.out.println("Range of Dates:");
		for(int i=1;i<=tableHeaderValues.size();i++){
			String headValue=dr.findElement(By.xpath(".//*[@class='month-wrapper']/table["+i+"]/thead/tr/th[@class='month-name']")).getText();
			//System.out.println(headValue);
			updateReport("Pass", "Range:Table Header Value", headValue+ " is the head value from the table",dr);
		}
		//Click the current date from calender
		Calendar cal = Calendar.getInstance();
		int day = cal.get(Calendar.DAY_OF_MONTH);
		String dayValue=Integer.toString(day);
		System.out.println("date:"+day);
		List<WebElement> tableValues=dr.findElements(By.xpath(".//*[@id='datepicker-obj-container']/div[1]/div[1]/table[1]/tbody/tr/td/div/div"));
		for(int i=1;i<=5;i++)
		{
			for(int j=1;j<=7;j++)
			{String element=dr.findElement(By.xpath(".//*[@id='datepicker-obj-container']/div[1]/div[1]/table[1]/tbody/tr["+i+"]/td["+j+"]/div/div")).getText();
				if(element.equals(dayValue))
				{WebElement dateSelection=dr.findElement(By.xpath(".//*[@id='datepicker-obj-container']/div[1]/div[1]/table[1]/tbody/tr["+i+"]/td["+j+"]/div/div"));
				clickElement(dateSelection,dateSelection.getText(),"Current date:"+dateSelection.getText()+" selection",dr);
				dr.findElement(By.xpath("//*[text()='Apply']")).click();
				Thread.sleep(2000);
				}
			}}

		Thread.sleep(7000);
		//Get the Default values from the Dropdown boxes:Frequency,Source,Price
		for(int j=2;j<=4;j=j+2)
		{
			String result=dr.findElement(By.xpath("//li["+j+"]/div[@class='control-select']/button/label")).getText()+dr.findElement(By.xpath("//li["+j+"]/div[@class='control-select']/button/span")).getText();
			updateReport("Pass", 
					dr.findElement(By.xpath("//li["+j+"]/div[@class='control-select']/button/label")).getText()+" Dropdown Default Value",
					dr.findElement(By.xpath("//li["+j+"]/div[@class='control-select']/button/label")).getText()+" Dropdown Default Value is:"+dr.findElement(By.xpath("//li["+j+"]/div[@class='control-select']/button/span")).getText(),
					dr);
		}
		String result2=dr.findElement(By.xpath("//*[@class='sourcepicker control-select']/button/label")).getText()+dr.findElement(By.xpath("//*[@class='sourcepicker control-select']/button/span")).getText();
		updateReport("Pass",
				dr.findElement(By.xpath("//*[@class='sourcepicker control-select']/button/label")).getText()+" Dropdown Default Value",
				dr.findElement(By.xpath("//*[@class='sourcepicker control-select']/button/label")).getText()+" Dropdown Default Value is:"+dr.findElement(By.xpath("//*[@class='sourcepicker control-select']/button/span")).getText(),
				dr);

	}
	
	@Test  
	public void OANDA_012() throws InterruptedException, IOException{
		dr.get("https://www.oanda.com/currency/converter/");
		WebElement liveExchangeRates=OANDA_ReusableMethodsTest.findTheElement("CurrencyConverter_LiveExchangeRates",OANDA_DriverScriptTest.browserRunning,dr);
		((JavascriptExecutor) dr).executeScript("arguments[0].scrollIntoView(true);", liveExchangeRates);
		clickElement(liveExchangeRates,"Live Exchange Rates","Live ExchangeRates Tab",dr);
		Thread.sleep(3000);
		checkContentsMatch(dr.getTitle(),"Live Exchange Rates | OANDA","Live Exchange Rates Page Title","Live Exchange Rates Page Title",dr);
		WebElement jumpTo=OANDA_ReusableMethodsTest.findTheElement("CurrencyConverter_LiveExchangeRatesJumpto",OANDA_DriverScriptTest.browserRunning,dr);
		dropDownByValue(jumpTo,"Majors","LiveExchangeRates: Jumpto Dropdown",dr);
		dropDownByValue(jumpTo,"EUR","LiveExchangeRates: Jumpto Dropdown",dr);
		dropDownByValue(jumpTo,"USD","LiveExchangeRates: Jumpto Dropdown",dr);
		dropDownByValue(jumpTo,"Others","LiveExchangeRates: Jumpto Dropdown",dr);
		dropDownByValue(jumpTo,"Metals","LiveExchangeRates: Jumpto Dropdown",dr);
		for(int i=1;i<=13;i=i+3)
		{
			WebElement tableHeader=dr.findElement(By.xpath(".//*[@id='menu_content']/div["+i+"]/div[1]/div[1]"));
			readingText(tableHeader,"Table Header",dr);
			
		}
		
	}
		
	
		@AfterMethod
	public void closeBrowser() throws IOException{
		updateResults();
		dr.close();
		dr.quit();
	}


}




