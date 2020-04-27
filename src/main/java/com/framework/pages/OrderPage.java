package com.framework.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver.Window;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.framework.general.Base;
import com.framework.general.WaitLib;
import com.framework.util.TestUtil;
import org.openqa.selenium.JavascriptExecutor; 
public class OrderPage extends Base{
	
TestUtil testUtil = new TestUtil();
WaitLib  waitLib  = new WaitLib();
	
	
	//Page Factory Login Page
	public OrderPage(){
	PageFactory.initElements(driver, this);
	}
	
	//Xpath
	@FindBy(xpath="//input[@id='dish-search']")
	WebElement enterPin;
	
	
	@FindBy(xpath="//span[@class='u-showAboveMid c-searchInput-button-text']")
	WebElement search;
	
	
	@FindBy(xpath = "//div[@class='g g--gutter g--stack--mid']//div[1]//div[1]//section[13]//a[1]//div[3]//h3[1]")
	WebElement food;
	
	@FindBy(xpath="//div[@class='deliveryOption selected']//span[@class='estimateTimeLabel']")
	WebElement collection;

	
	
	@FindBy(xpath="//div[@id='basket']//button[@class='allergenDefaultLink o-btn o-btn--reset o-link']")
	WebElement clicklink;
	
	
	@FindBy(xpath="//button[@class='advisoryDialogClose o-btn o-btn--primary allergen-modal-text']")
	WebElement closeButton;
	
	
	@FindBy(xpath ="//li[@class='c-nav-list-item']//a[@class='c-nav-list-link']")
	WebElement login;
	
	
	@FindBy(xpath ="//input[@id='Email']")
	WebElement email;
	
	
	@FindBy(xpath ="//input[@id='Password']")
	WebElement pwd;
	
	@FindBy(xpath ="//span[@class='u-showAboveMid']")
	WebElement sort;
	
	@FindBy(id ="Distance")
	WebElement distance;
	
	
	@FindBy(xpath = "//div[contains(@class,'u-showAboveMid')]//div[contains(@class,'has-ex-1150-active header-filters-container c-overflowCarousel c-searchFilterSection-filterList c-overflowCarousel--fromMid')]//span[5]//label[1]")
	WebElement indian;
	
	
	@FindBy(xpath = "//section[6]//a[1]//div[3]//h3[1]")
	WebElement indiancuisine;
	
	@FindBy(xpath ="//div[@id='cat0']//div[3]//div[2]//div[1]//form[1]//div[1]//button[1]")
	WebElement add;
	
	@FindBy(xpath ="//*[name()='path' and contains(@d,'M138.334 3')]")
	WebElement title;
	
	
	@FindBy(xpath="//li[@class='c-nav-list-item c-nav-list-item--support']//a[@class='c-nav-list-link']")
	WebElement help;
	
	public void searchbest() throws Exception {
		/*
		 * Actions action = new Actions(driver);
		 * action.moveToElement(sort).build().perform(); Thread.sleep(3000);
		 * distance.click();
		 * 
		 */
		indian.click();
		waitLib.explicitWait(driver,10,indian);
		 ((JavascriptExecutor)driver).executeScript("scrollTo(0,1500)"); 
		 testUtil.clickElement(indiancuisine, "Click on indian food");
			waitLib.explicitWait(driver,10,indiancuisine);
		 ((JavascriptExecutor)driver).executeScript("scroll(0,800)"); 
		 testUtil.clickElement(add, "Add more +");
		
		
		
	}
	public void EnterPin() throws Exception {
		 testUtil.enterText(enterPin,"AR51 1AA","Search Pincode");
		 testUtil.clickElement(search,"Search on PinCode");
		// waitLib.explicitWait(driver,10,search);
		 // ((JavascriptExecutor)driver).executeScript("scroll(0,1000)"); 
		 
		  ((JavascriptExecutor)driver).executeScript("scrollTo(0,1500)"); 
		 // ((JavascriptExecutor)driver).executeScript("argument[0].scrollIntoView(true)",food); 
		  testUtil.clickElement(food, "Click on Food");
		  ((JavascriptExecutor)driver).executeScript("scrollTo(0,1500)"); 
		  testUtil.clickElement(collection, "Click on Collection Food");
		  waitLib.explicitWait(driver,10,collection);
		  testUtil.clickElement(clicklink, "Click on Link");
		  Thread.sleep(5000);
		  testUtil.clickElement(closeButton, "Close Button");
		
		 
	}

	public HelpPage Help() throws Exception {
		 testUtil.clickElement(help,"Click on help");
		 waitLib.explicitWait(driver,10,help);
		 return new HelpPage();
	}
	
	public String title() {
		return driver.getTitle();
	}

	


	

}
