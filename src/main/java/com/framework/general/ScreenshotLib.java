package com.framework.general;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.utils.FileUtil;

public class ScreenshotLib {
	
	public void getScreenshot(WebDriver driver, String filepath) throws IOException {
		TakesScreenshot srcshot = ((TakesScreenshot) driver);
		File srcfile = srcshot.getScreenshotAs(OutputType.FILE);
		File destfile =new File(filepath +".png ");
		FileUtils.copyFile(srcfile, destfile);
		
	}

}
