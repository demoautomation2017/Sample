package com.testing.Cliniops;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Method;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Cliniops_ReusableMethodsTest { 
	
	static WebDriver driver ;
	static String htmlname;
	static Date cur_dt = null;
	static BufferedWriter bw = null;
	static BufferedWriter bw1 = null;
	static String exeStatus = "True";
	static int report;
	static int j = 1;
	

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
			//System.out.println("Pass"+ "enterText"+textVal + " is entered in " + objName);
			Update_Report("Pass","entertext",textVal+" is entered in "+objName);
			
		}else{
			//System.out.println("Fail"+ "enterText"+objName + " field is not displayed, please check your application.");
			Update_Report("Fail","entertext",objName+" field is not displayed,please check application");
			
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
	
	//Name of the method:ButtonClick
		//Brief description:used to click the button
		//arguments:obj->WebElement,objname->name of the object
		//created by:Automation team
		//creation date:12/15/2016
		//modified date:12/15/2016
		public static void ButtonClick(WebElement obj,String objname) throws IOException{
			if(obj.isDisplayed())
			{obj.click();
			Update_Report("Pass","ButtonClick",objname+" is clicked");
				//System.out.println("Pass:"+objname+" is clicked");
			}
			else{
				Update_Report("Fail","ButtonClick",objname+" is not displayed");
				//System.out.println("Fail:"+objname+" is not displayed");
				}	
		}
		
		//Name of the method:ErrorMessage
			//Brief description:used to display message on matching actual text with expected text
			//arguments:obj->WebElement,Expectedtext->text used to compare with actual text,objname->name of the object
			//created by:Automation team
			//creation date:12/15/2016
			//modified date:12/15/2016
			public static void ErrorMessage(WebElement obj,String Expectedtext,String objname) throws IOException{
				if(obj.isDisplayed())
				{
					String Actualtext=obj.getText().trim();
					if(Expectedtext.trim().contains(Actualtext.trim())){
						Update_Report("Pass","ErrorMessage","Actual message matching with expected message:"+Actualtext);
						//System.out.println("Pass:Actual message matching with expected message:"+Actualtext);
						}
				else{Update_Report("Fail","ErrorMessage","Actual message not matching with expected message:"+Actualtext);
					//System.out.println("Fail:Actual message not matching with expected message"+Actualtext);
					}
				}
				else{Update_Report("Fail","ErrorMessage",objname+" is not displayed,please check your application");
					//System.out.println("Fail:"+objname+" is not displayed,please check your application");
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
			/* 
			 * Name of the Method: validateMsg_Attribute
			 * Brief description : validate message displayed on the web page
			 * Arguments: obj --> Webelement Object,  expectedText --> expected text to be displayed, objName --> name of the object
			 * Created by: Automation team
			 * Creation date : July 20 2017
			 * last modified: July 20 2017
			 * 
			 * */	

			public static void validateMsg_Attribute(WebElement obj, String expectedText, String objName,String attributeName){
				if(obj.isDisplayed()){
					String actualText = obj.getAttribute(attributeName);
					if(expectedText.equals(actualText)){
						System.out.println("Pass: Actual message is matching with expected message " + actualText);
					}else{
						System.out.println("Fail: Actual message '" + actualText + "' is not matching with expected message '"+ expectedText+"'  ,Please check your application");
					}
				}else{
					System.out.println("Fail: " + objName+ " is not displayed, please check your application");
				}
			}
			
			//Name of the method:Readingtext
				//Brief description:Reading text box value
				//arguments:obj->WebElement,objname->name of the object
				//created by:Automation team
				//creation date:12/15/2016
				//modified date:12/15/2016
				public static void ReadingText(WebElement obj,String objname) throws IOException{
					if(obj.isDisplayed())
					{
						String Actualtext=obj.getText().trim();
						if(Actualtext.isEmpty()){Update_Report("Fail","ReadingText",objname+" has No data");
							//System.out.println("Fail:"+objname+" has No data");
							}
					else{Update_Report("Pass","ReadingText",objname+" contains "+Actualtext);
						//System.out.println("Pass:"+objname+" contains "+Actualtext);
						}
					}
				}	
				
				//Name of the method:readingCheckbox
					//Brief description:Reading check box value
					//arguments:obj->WebElement,objname->name of the object
					//created by:Automation team
					//creation date:12/15/2016
					//modified date:12/15/2016
					public static void readingCheckbox(WebElement obj,String Expectedtext,String objname) throws IOException{
						if(obj.isDisplayed())
						{
							String Actualtext=obj.getAttribute("checked").trim();
							if(Expectedtext.equals(Actualtext)){
								Update_Report("Pass","readingCheckbox",objname+" is checked");
								//System.out.println("Pass:"+objname+" is checked");
								}
						else{Update_Report("Fail","readingCheckbox",objname+" is not checked");
							//System.out.println("Fail:"+objname+" is not checked");
							}
						}
						else{Update_Report("Fail","readingCheckbox",objname+" is not displayed,please check your application");
							//System.out.println("Fail:"+objname+" is not displayed,please check your application");
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
	public static void startReport(String scriptName, String ReportsPath) throws IOException{
		//public static void startReport(Method testcase, String ReportsPath) throws IOException{
		
			String strResultPath = null;
			String testScriptName =scriptName;
			//Method testScriptName =testcase;
		
			cur_dt = new Date(); 
			DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss");
			String strTimeStamp = dateFormat.format(cur_dt);
		
			if (ReportsPath == "") { 
		
				ReportsPath = "C:\\";
			}
		
			if (ReportsPath.endsWith("\\")) { 
				ReportsPath = ReportsPath + "\\";
			}
		
			strResultPath = ReportsPath + "Log" + "/" +testScriptName +"/"; 
			File f = new File(strResultPath);
			f.mkdirs();
			htmlname = strResultPath  + testScriptName + "_" + strTimeStamp 
					+ ".html";
		
			bw = new BufferedWriter(new FileWriter(htmlname));
		
			bw.write("<HTML><BODY><TABLE BORDER=0 CELLPADDING=3 CELLSPACING=1 WIDTH=100%>");
			bw.write("<TABLE BORDER=0 BGCOLOR=BLACK CELLPADDING=3 CELLSPACING=1 WIDTH=100%>");
			bw.write("<TR><TD BGCOLOR=#66699 WIDTH=27%><FONT FACE=VERDANA COLOR=WHITE SIZE=2><B>Browser Name</B></FONT></TD><TD COLSPAN=6 BGCOLOR=#66699><FONT FACE=VERDANA COLOR=WHITE SIZE=2><B>"
					+ "FireFox " + "</B></FONT></TD></TR>");
			bw.write("<HTML><BODY><TABLE BORDER=1 CELLPADDING=3 CELLSPACING=1 WIDTH=100%>");
			bw.write("<TR COLS=7><TD BGCOLOR=#BDBDBD WIDTH=3%><FONT FACE=VERDANA COLOR=BLACK SIZE=2><B>SL No</B></FONT></TD>"
					+ "<TD BGCOLOR=#BDBDBD WIDTH=10%><FONT FACE=VERDANA COLOR=BLACK SIZE=2><B>Step Name</B></FONT></TD>"
					+ "<TD BGCOLOR=#BDBDBD WIDTH=10%><FONT FACE=VERDANA COLOR=BLACK SIZE=2><B>Execution Time</B></FONT></TD> "
					+ "<TD BGCOLOR=#BDBDBD WIDTH=10%><FONT FACE=VERDANA COLOR=BLACK SIZE=2><B>Status</B></FONT></TD>"
					+ "<TD BGCOLOR=#BDBDBD WIDTH=47%><FONT FACE=VERDANA COLOR=BLACK SIZE=2><B>Detail Report</B></FONT></TD></TR>");
		
		
		}
		
		public static void Update_Report(String Res_type,String Action, String result) throws IOException {
			String str_time;
			Date exec_time = new Date();
			DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss");
			str_time = dateFormat.format(exec_time);
			if (Res_type.startsWith("Pass")) {
				bw.write("<TR COLS=7><TD BGCOLOR=#EEEEEE WIDTH=3%><FONT FACE=VERDANA SIZE=2>"
						+ (j++)
						+ "</FONT></TD><TD BGCOLOR=#EEEEEE WIDTH=10%><FONT FACE=VERDANA SIZE=2>"
						+Action
						+ "</FONT></TD><TD BGCOLOR=#EEEEEE WIDTH=10%><FONT FACE=VERDANA SIZE=2>"
						+ str_time
						+ "</FONT></TD><TD BGCOLOR=#EEEEEE WIDTH=10%><FONT FACE=VERDANA SIZE=2 COLOR = GREEN>"
						+ "Passed"
						+ "</FONT></TD><TD BGCOLOR=#EEEEEE WIDTH=30%><FONT FACE=VERDANA SIZE=2 COLOR = GREEN>"
						+ result + "</FONT></TD></TR>");
		
			} else if (Res_type.startsWith("Fail")) {
				exeStatus = "Failed";
				report = 1;
				bw.write("<TR COLS=7><TD BGCOLOR=#EEEEEE WIDTH=3%><FONT FACE=VERDANA SIZE=2>"
						+ (j++)
						+ "</FONT></TD><TD BGCOLOR=#EEEEEE WIDTH=10%><FONT FACE=VERDANA SIZE=2>"
						+Action
						+ "</FONT></TD><TD BGCOLOR=#EEEEEE WIDTH=10%><FONT FACE=VERDANA SIZE=2>"
						+ str_time
						+ "</FONT></TD><TD BGCOLOR=#EEEEEE WIDTH=10%><FONT FACE=VERDANA SIZE=2 COLOR = RED>"
						+ "<a href= "
						+ htmlname
						+ "  style=\"color: #FF0000\"> Failed </a>"
		
					+ "</FONT></TD><TD BGCOLOR=#EEEEEE WIDTH=30%><FONT FACE=VERDANA SIZE=2 COLOR = RED>"
					+ result + "</FONT></TD></TR>");
					
		
			} 
		}
	}
