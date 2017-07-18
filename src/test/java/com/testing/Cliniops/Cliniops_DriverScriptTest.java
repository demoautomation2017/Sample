package com.testing.Cliniops;

	import java.io.IOException;
	import java.lang.reflect.InvocationTargetException;
	import java.lang.reflect.Method;

	public class Cliniops_DriverScriptTest {//extends Cliniops_AutomationScriptsTest {

		public static void main(String[] args) throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, IOException, ClassNotFoundException, InstantiationException{
			
			Cliniops_AutomationScriptsTest CAS = new Cliniops_AutomationScriptsTest();
			String testDataPath = "C:/kiranmai/cliniops_reflectionSuite/cliniops_refl.xls";
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
						System.out.println("i: "+i+" Data in this cell "+recData[i][2]);
						//we are getting handle to the method for invoking...
						Method testcase = Cliniops_AutomationScriptsTest.class.getMethod(tc);
						
						//invoke actually executes the method
						if(recData[i][3].equalsIgnoreCase("Y")){
							CAS.Selectbrowser("firefox");
							testcase.invoke(CAS);
							CAS.closeBrowser();
						}

						if(recData[i][4].equalsIgnoreCase("Y")){
							CAS.Selectbrowser("chrome");
							testcase.invoke(CAS);
							CAS.closeBrowser();
							
						}
						if(recData[i][5].equalsIgnoreCase("Y")){
							CAS.Selectbrowser("IE");
							testcase.invoke(CAS);
							CAS.closeBrowser();

						}						
										
					
				}
			}
		}	

		}