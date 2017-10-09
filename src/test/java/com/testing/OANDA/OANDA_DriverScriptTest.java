package com.testing.OANDA;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;

import org.apache.tools.ant.taskdefs.UpToDate;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
   
public class OANDA_DriverScriptTest {           
   
	//static int x;
	static ArrayList elementList=new ArrayList();
	static String[][] locatorsData;
	static String browserRunning;
	@BeforeSuite
	public void beforeSuiteExecution() throws Exception{
		String locatorsPath =".\\objectRepository\\locatorsObjectRepo.xls";
		String testDataSheet="Sheet1";
		locatorsData = OANDA_ReusableMethodsTest.readSheet(locatorsPath, testDataSheet);
		
		for(int i=0;i<locatorsData.length;i++){  
			elementList.add(locatorsData[i][0]);
		}
		System.out.println(elementList);
		System.out.println("------Done--------");
	}
     
	@Test
	public static void Runner() throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, IOException, ClassNotFoundException, InstantiationException{

		OANDA_AutomationScriptsTest casObject = new OANDA_AutomationScriptsTest();
		String testDataPath =".\\OANDA_AutomationScripts_Execution.xls";
		String reportsPath=".\\test-output\\suite\\";
		//String reportsPath=System.getProperty("user.dir")+"\\test-output\\";
		String testDataSheet="Sheet1";
		String[][] recData = OANDA_ReusableMethodsTest.readSheet(testDataPath, testDataSheet);
		String tc = null;
		//looping through the rows
		for(int i=0; i<recData.length; i++){

			if (recData[i][1].equalsIgnoreCase("y")){
				tc = recData[i][2];
				System.out.println("Testcase to run: "+recData[i][2]);

				//we are getting handle to the method for invoking...
				Method testcase = OANDA_AutomationScriptsTest.class.getMethod(tc);
				
				//invoke---executes the method
				if(recData[i][3]!=null && recData[i][3].equalsIgnoreCase("Y"))
				{
					OANDA_ReusableMethodsTest.startReport(tc, reportsPath,"FIREFOX");
					browserRunning="firefox";
					casObject.selectBrowser("firefox");
					testcase.invoke(casObject);
					casObject.closeBrowser();
					
				}
				if(recData[i][4]!=null && recData[i][4].equalsIgnoreCase("Y"))
				{
					OANDA_ReusableMethodsTest.startReport(tc, reportsPath,"CHROME");
					browserRunning="chrome";
					casObject.selectBrowser("chrome");
					testcase.invoke(casObject);
					casObject.closeBrowser();
					
				}
				if(recData[i][5]!=null && recData[i][5].equalsIgnoreCase("Y"))
				{
					OANDA_ReusableMethodsTest.startReport(tc, reportsPath,"IE");
					browserRunning="ie";
					casObject.selectBrowser("IE");
					testcase.invoke(casObject);
					casObject.closeBrowser();
					
				}	
				//OANDA_ReusableMethodsTest.bw.close();
				//Update Data for Summary Report after test run for all browsers
				OANDA_ReusableMethodsTest.updateSummaryReport();
				//Close individual test script report
				OANDA_ReusableMethodsTest.closeReport();	
					
			}
			else if(recData[i][1].equalsIgnoreCase("n")){
				System.out.println(recData[i][2] + "in line number "+i+ "skipped from execution");
			}
			
		}	
		
		//Write and close summary report
		OANDA_ReusableMethodsTest.writeSummaryReport(reportsPath);
	}
}

