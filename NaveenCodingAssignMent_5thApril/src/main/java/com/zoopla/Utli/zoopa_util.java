package com.zoopla.Utli;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import com.zoopla.BaseClass.BaseClass;

public class zoopa_util extends BaseClass {
	
	
	
	
	public static void ClickElement(WebElement e) {
		e.click();
	}
	
	
	public static void SendKey(WebElement e, String s) {
		e.sendKeys(s);
	}

	public static void JavaScriptClick(WebElement e) {
		JavascriptExecutor je = (JavascriptExecutor) driver;
	    je.executeScript("arguments[0].click();", e);
	}
}
