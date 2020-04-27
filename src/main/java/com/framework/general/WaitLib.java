package com.framework.general;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

//Wait statements
public class WaitLib {

	public FluentWait<WebDriver> fw;

	public static void hardWait(int time) {
		try {
			Thread.sleep(time);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void implicitWait(WebDriver driver, int time) {
		driver.manage().timeouts().implicitlyWait(time, TimeUnit.SECONDS);
	}

	public  void implicitWaitforMinutes(WebDriver driver, int time) {
		driver.manage().timeouts().implicitlyWait(time, TimeUnit.MINUTES);
	}

	public  void explicitWait(WebDriver driver, int time,
			WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, time);
		wait.until(ExpectedConditions.visibilityOf(element));
	}

	public void waitForAjax(WebDriver driver) {

		try {
			WebDriverWait driverWait = new WebDriverWait(driver, 20);

			ExpectedCondition<Boolean> expectation;
			expectation = new ExpectedCondition<Boolean>() {

				public Boolean apply(WebDriver driverjs) {

					JavascriptExecutor js = (JavascriptExecutor) driverjs;
					return js
							.executeScript(
									"return((window.jQuery != null) && (jQuery.active === 0))")
							.equals("true");
				}
			};
			driverWait.until(expectation);
		} catch (TimeoutException exTimeout) {

			// fail code
		} catch (WebDriverException exWebDriverException) {

			// fail code
		}
	}

}
