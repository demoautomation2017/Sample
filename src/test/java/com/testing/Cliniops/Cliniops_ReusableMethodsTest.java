package com.testing.Cliniops;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Cliniops_ReusableMethodsTest { 
	
	static WebDriver driver ;
	

	/* 
	 * Name of the Method: enterText
	 * Brief description : Enter text into text box field
	 * Arguments: obj --> Webelement Object, textval --> Text to be entered, objName --> name of hte object
	 * Created by: Automation team
	 * Creation date : July 17 2017
	 * last modified:  2017
	 * */
	public static void enterText(WebElement obj, String textVal, String objName) throws IOException{
		if(obj.isDisplayed()){
			obj.sendKeys(textVal);
			System.out.println("Pass"+ "enterText"+textVal + " is entered in " + objName);
			
		}else{
			System.out.println("Fail"+ "enterText"+objName + " field is not displayed, please check your application.");
			
		}

	}
	/* 
	 * Name of the Method: dropDown
	 * Brief description : Selecting the DropDown
	 * Arguments: obj --> Webelement Object, textval --> Text to be entered 
	 * Created by: Automation team
	 * Creation date : July 17 2017
	 * last modified:  July 17 2017
	 * */
	public static void dropDown(WebElement dd, int index){
		
		Select select = new Select(dd);
		if(dd.isDisplayed()){
			select.selectByIndex(index);
			System.out.println("Pass" +dd+ "is selected");
		}
			else{
				System.out.println("Fail" +dd + "is not displayed");
			}
		
	}

	/* 
	 * Name of the Method: clickObj
	 * Brief description : click object
	 * Arguments: obj --> Webelement Object,  objName --> name of the object
	 * Created by: Automation team
	 * Creation date : July 17 2017
	 * last modified: July 17 2017
	 * 
	 * */	
	public static void clickObj(WebElement obj, String objName){
		if(obj.isDisplayed()){
			obj.click();
			System.out.println("Pass: "+ objName + " is clicked.");
		}else{
			System.out.println("Fail: " + objName+ " is not displayed, please check your application");
		}
	}

	/* 
	 * Name of the Method: validateMsg
	 * Brief description : validate message displayed on the web page
	 * Arguments: obj --> Webelement Object,  expectedText --> expected text to be displayed, objName --> name of hte object
	 * Created by: Automation team
	 * Creation date : July 17 2017
	 * last modified: July 17 2017
	 * 
	 * */	

	public static void validateMsg(WebElement obj, String expectedText, String objName){
		if(obj.isDisplayed()){
			String actualText = obj.getText().trim();
			if(expectedText.equals(actualText)){
				System.out.println("Pass: Actual message is matching with expected message " + actualText);
			}else{
				System.out.println("Fail: Actual message '" + actualText + "' is not matching with expected message '"+ expectedText+"'  ,Please check your application");
			}
		}else{
			System.out.println("Fail: " + objName+ " is not displayed, please check your application");
		}
	}
	
//	/*
//	 * Name of method : toBeClickable
//	 * Brief description : wait for the given time until the webelement is located
//	 * Arguments:
//	 * Created By :
//	 * Creation Date
//	 * Last Modified:
//	 */
//	
//	public static void toBeClickable(int timeInMilliSec, WebElement element){
//		
//		WebDriverWait wait = new WebDriverWait(driver, timeInMilliSec);
//		WebElement elementToClick = wait.until(ExpectedConditions.elementToBeClickable(element));
//		elementToClick.click();
//		System.out.println("clicked on the given element....");
//		
//	}
	
	public static String[][] readSheet(String dataTable, String sheetName) throws IOException{


		/*Step 1: Get the XL Path*/
		File xlFile = new File(dataTable);

		/*Step2: Access the Xl File*/
		FileInputStream xlDoc = new FileInputStream(xlFile);

		/*Step3: Access the work book */
		HSSFWorkbook wb = new HSSFWorkbook(xlDoc);


		/*Step4: Access the Sheet */
		HSSFSheet sheet = wb.getSheet(sheetName);

		int iRowCount =  sheet.getLastRowNum()+1;
		int iColCount = sheet.getRow(0).getLastCellNum();//Row count starts from '0' in excel

		System.out.println("Total row = " + iRowCount + " total col = " + iColCount);

		String[][] xlData = new String[iRowCount][iColCount];

		for(int i =0; i<iRowCount;i++){
			for(int j = 0; j <iColCount;j++){
				xlData[i][j] = sheet.getRow(i).getCell(j).getStringCellValue().trim();
			}

		}
		
		return xlData;
	}
	}
