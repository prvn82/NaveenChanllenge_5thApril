package com.zoopa.TestCases;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.zoopla.BaseClass.BaseClass;
import com.zoopla.pages.SearchPage;
import com.zoopla.pages.Zoopa_HomePage;

//Test Details: 1. Printing Prices of Listed Property in Descending order
//                2. Clicking on 5th Listed property and Validating if correct Page has  opened

public class SearchPageTest extends BaseClass {
	
	
	 private Zoopa_HomePage Homapge;
	 private SearchPage search;
	
	
	@BeforeClass
	public void init() {
		
		System.out.println("**************");
		Homapge=new Zoopa_HomePage();
		search=Homapge.EnterSearch();
	}
	
	
	@Test(priority=1)
	public void printPriceListDescendingOrderTest() {
		
		List<WebElement> propertyList = search.getPropertyList();
		
		List<Integer> order = new ArrayList<>();
		
		for(WebElement e : propertyList) {
    		String text = e.getText();
    		getIntegerValue(text);
    		order.add(getIntegerValue(text));
    	
    	}
    	
    	Collections.sort(order);
    	Collections.reverse(order);
    	
    	for(Integer i : order) {
    		System.out.println(i);
    	}
	}

	@Test(priority=2)
	public void click_On_5th_Property_AND_Verify() {
		
		search.ClickOnProperty();
		
	}
	
	private Integer getIntegerValue(String s) {
    	String[] split = s.split(" ");
		String[] split2 = split[0].split("£");
		String replaceAll = split2[1].replaceAll(",", "");
		Integer int_PriceValue = Integer.parseInt(replaceAll);
		return int_PriceValue;
    }
}
