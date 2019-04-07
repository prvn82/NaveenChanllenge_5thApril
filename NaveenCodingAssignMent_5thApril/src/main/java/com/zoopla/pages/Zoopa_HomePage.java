package com.zoopla.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.zoopla.BaseClass.BaseClass;
import com.zoopla.Utli.zoopa_util;

public class Zoopa_HomePage extends BaseClass{
	
	
	@FindBy(xpath="//input[@id='search-input-location']")
	private WebElement SearchBox;
	
	@FindBy(xpath="//button[@id='search-submit']")
	private WebElement SearchKey;
	
	public Zoopa_HomePage() {
		
		PageFactory.initElements(driver, this);
	}
	
	
	public void ValidateTiltle() {
		
		System.out.println(driver.getTitle());
		
		Assert.assertEquals(driver.getTitle(), "Zoopla > Search Property to Buy, Rent, House Prices, Estate Agents", "HomePage Title does not match");
	}
	
	
	public SearchPage EnterSearch() {
		
		zoopa_util.SendKey(SearchBox, Config.getProperty("SearchKeyWord"));
		zoopa_util.ClickElement(SearchKey);
		return new SearchPage() ;
		
	}

}
