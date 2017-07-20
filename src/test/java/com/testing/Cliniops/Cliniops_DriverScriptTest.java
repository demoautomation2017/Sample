package com.testing.Cliniops;

	import java.io.IOException;
	import java.lang.reflect.InvocationTargetException;
	import java.lang.reflect.Method;

import org.apache.tools.ant.taskdefs.UpToDate;
import org.testng.annotations.Test;

	public class Cliniops_DriverScriptTest {//extends Cliniops_AutomationScriptsTest {

		//public static void main(String[] args) throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, IOException, ClassNotFoundException, InstantiationException{
		@Test
		public static void cliniops_driver() throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, IOException, ClassNotFoundException, InstantiationException{
			
			Cliniops_AutomationScriptsTest CAS = new Cliniops_AutomationScriptsTest();
			String testDataPath = "C:/kiranmai/cliniops_reflectionSuite/cliniops_refl.xls";
			String ReportsPath="C:/Users/Sreeram/git/Testing_Cliniops/test-output/Suite/CliniOps_Report";
			
			System.out.println("Executing cliniops application using Reflection....");

			String[][] recData = Cliniops_ReusableMethodsTest.readSheet(testDataPath, "Sheet1");
			System.out.println(recData.length);
			String tc = null;
			//Method testcase = AutomationScript.class.getMethod(tc,String.class);
			//looping through the rows
			for(int i=0; i<recData.length; i++){

				//looping through the columns
				//for (int j=3;j<recData[0].length; j++){

					//System.out.println("j: "+ j);
					if (recData[i][1].equalsIgnoreCase("y")){
						tc = recData[i][2];
						System.out.println("Testcase to run: "+recData[i][2]);
						
						//we are getting handle to the method for invoking...
						Method testcase = Cliniops_AutomationScriptsTest.class.getMethod(tc);
						
						Cliniops_ReusableMethodsTest.startReport(tc, ReportsPath);
						//invoke actually executes the method
						if(recData[i][3].equalsIgnoreCase("Y")){
							CAS.Selectbrowser("firefox");
							testcase.invoke(CAS);
							CAS.closeBrowser();
							
							//closing bufferwriter
							Cliniops_ReusableMethodsTest.bw.close();
						}

						if(recData[i][4].equalsIgnoreCase("Y")){
							CAS.Selectbrowser("chrome");
							testcase.invoke(CAS);
							CAS.closeBrowser();
							Cliniops_ReusableMethodsTest.bw.close();
							
						}
						if(recData[i][5].equalsIgnoreCase("Y")){
							CAS.Selectbrowser("IE");
							testcase.invoke(CAS);
							CAS.closeBrowser();
							Cliniops_ReusableMethodsTest.bw.close();

						}						
										
					
				}
					else if(recData[i][1].equalsIgnoreCase("n"))
						System.out.println(recData[i][2] + "in line number "+i+ "skipped from execution");
			}
		}	

		}