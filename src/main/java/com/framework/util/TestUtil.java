package com.framework.util;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

import org.apache.commons.io.FileUtils;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.framework.general.Base;

public class TestUtil extends Base{

	public static long PAGE_LOAD_TIMEOUT = 20;
	public static long IMPLICIT_WAIT = 20;
	public static WebDriverWait wait;

	public static String TESTDATA_SHEET_PATH = "C:\\Users\\Anum Zargar\\eclipse-workspace"
			+ "\\Demo\\src\\main\\java\\com\\framework\\testdata\\AddClientTestData.xlsx";


	static Workbook book;
	static Sheet sheet;
	static JavascriptExecutor js;

	public void switchToFrame() {
		driver.switchTo().frame("mainpanel");
	}

	public static Object[][] getTestData(String sheetName) {
		FileInputStream file = null;
		try {
			file = new FileInputStream(TESTDATA_SHEET_PATH);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		try {
			book = WorkbookFactory.create(file);
		} catch (InvalidFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		sheet = book.getSheet(sheetName);
		Object[][] data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
		// System.out.println(sheet.getLastRowNum() + "--------" +
		// sheet.getRow(0).getLastCellNum());
		for (int i = 0; i < sheet.getLastRowNum(); i++) {
			for (int k = 0; k < sheet.getRow(0).getLastCellNum(); k++) {
				data[i][k] = sheet.getRow(i + 1).getCell(k).toString();
				// System.out.println(data[i][k]);
			}
		}
		return data;
	}
	 
  public void clickElement(WebElement element, String msg) throws Exception
{
    try
    {
  	  //Thread.sleep(3000);
    //	waitForElement(element);
	    element.click();
	    stepPassed("Clicked on " + msg);
}
catch(Exception e)
{
    stepFailed("Unable to click on " + msg +" due to "+e.getMessage());
        throw e;
    }

}
  
	  public void enterText(WebElement element, String value, String msg) throws Exception
	{
	    try
	    {
	       //Thread.sleep(3000);
		  // waitForElement(element);
		   element.clear();
		   element.sendKeys(value);
		   stepPassed(value + " entered into " + msg);
	    }
		catch (Exception e)
		{
		    stepFailed("Unable to enter text into " + msg + " due to " + e.getMessage());
		        throw e;
		 }
		
	}
  
  
  public boolean waitForElement(WebElement element) { 
	  
	  boolean flag = false; 
	  try
	  { 
		  WebDriverWait wait= new WebDriverWait(driver, 30);
		  WebElement Element= wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("element"))));
		  Element.click();
	  }
		  catch (Throwable error) 
		  {
			 Assert.fail("Timeout waiting for Page Load Request to complete.");
		
		  }
  return flag;
		  
		  }
		 private void stepFailed(String string)
		 {
					// TODO Auto-generated method stub
			
		   }
		private void stepPassed(String string) 
		{
			// TODO Auto-generated method stub
					
		
		}

		public static void takeScreenshotAtEndOfTest(WebDriver driver) throws IOException {
			File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			String currentDir = System.getProperty("user.dir");
			String date = new SimpleDateFormat("yyyyMddhmss").format(new Date());
			FileUtils.copyFile(scrFile, new File(currentDir + "/screenshots/" + date+ ".png"));
		}
		
	

		/*
		 * public void explicitWait(WebDriver driver,int time,WebElement element) { wait
		 * = new WebDriverWait(driver,time);
		 * wait.until(ExpectedConditions.visibilityOf(element));
		 * 
		 * }
		 * 
		 * public void implicitWait(WebDriver driver,int time) {
		 * driver.manage().timeouts().implicitlyWait(time, TimeUnit.SECONDS); }
		 * 
		 * public void implicitWaitMinutes(WebDriver driver,int time) {
		 * driver.manage().timeouts().implicitlyWait(time, TimeUnit.MINUTES); }
		 */

		
		public static void click(WebDriver driver,WebElement element,int timeout) {
			new WebDriverWait(driver,timeout).
			until(ExpectedConditions.elementToBeClickable(element));
			element.click();
		}
		
		public static void sendKeys(WebDriver driver,WebElement element,int timeout,String value) {
			new WebDriverWait(driver,timeout).
			until(ExpectedConditions.visibilityOf(element));
			element.sendKeys(value);
		}
		
		public  void SelectDropDown(WebElement element,String value) {
			Select s= new Select(element);
		    s.selectByVisibleText(value);
		}
		
		public  void SelectDropDownValue(String xpathValue,String Value) {
			List<WebElement> referalist =driver.findElements(By.xpath(xpathValue));
			System.out.println("Size of referal type " +referalist.size());
			for (int i = 0; i < referalist.size(); i++) {
				System.out.println(referalist.get(i).getText());
				if(referalist.get(i).getText().equals(Value)) {
					referalist.get(i).click();
					break;
		}
			
		}
}

		public static void takeScreenshotAtEndOfTest() {
			// TODO Auto-generated method stub
			
		}
}