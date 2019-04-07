package com.zoopla.pages;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.zoopla.BaseClass.BaseClass;
import com.zoopla.Utli.zoopa_util;

import junit.framework.Assert;

public class SearchPage extends BaseClass {
	
	@FindBy(xpath="//ul[@class='listing-results clearfix js-gtm-list']/li[@id]/div/div[2]/a")
	private List<WebElement> PriceLists;
	
	
	
	
   public SearchPage() {
		
		PageFactory.initElements(driver, this);
	}
     
     public List<WebElement> getPropertyList(){
    	 return PriceLists;
     }
	
    
    
    
    public PropertPage ClickOnProperty() {
    	
    	List<WebElement> propertyList = getPropertyList();
		int count=0;
		
		for(WebElement e1 : propertyList) {
			count++;
			
    		if(count==5) {
    			
    			String href = e1.getAttribute("href");

    			zoopa_util.JavaScriptClick(e1);
                String PropertyPageURl=driver.getCurrentUrl();
    			
    		    if(PropertyPageURl.contains(href)) {
    		    	
    		    	Assert.assertTrue(true);
    		    	
    		    }
    		    else {
    		    	Assert.assertFalse("Clicked Property and opened property are different", true);
    		    }
    			break;
    		}
    	
    	}
    	
    	
    	
    	return new PropertPage();
    	
    }
    
    
    
    
 
    

}
