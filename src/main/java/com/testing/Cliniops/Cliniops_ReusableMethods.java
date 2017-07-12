package com.testing.Cliniops;

public class Cliniops_ReusableMethodsTest { 

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
			Update_Report("Pass", "enterText", textVal + " is entered in " + objName);
			
		}else{
			Update_Report("Fail", "enterText", objName + " field is not displayed, please check your application.");
			
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
	}
}