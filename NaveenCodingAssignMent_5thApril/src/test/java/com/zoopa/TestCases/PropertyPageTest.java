package com.zoopa.TestCases;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.zoopla.BaseClass.BaseClass;
import com.zoopla.pages.PropertPage;
import com.zoopla.pages.SearchPage;
import com.zoopla.pages.Zoopa_HomePage;


/*
Test Details: 1. Printing Agent details i.e. Logo,Name and PhoneNumber
              2. Saving Agent name for subsquent Test verification
              3. Clicking on agent Name*/
public class PropertyPageTest extends BaseClass {
	
	
	private Zoopa_HomePage Homapge;
	 private SearchPage search;
	 private PropertPage prop;
	
	
	@BeforeClass
	public void init() {
		
		System.out.println("**************");
		Homapge=new Zoopa_HomePage();
		search=Homapge.EnterSearch();
		prop=search.ClickOnProperty();
	}
	
	@Test
	public void ValidateAgentDetails() {
		prop.PrintAgentDetaisl();
	}
	
	@Test(priority=1)
	public void validateLogoTest() {
	Assert.assertTrue(prop.ValidateLogo());
	}
	
	@Test(priority=2)
	public void validateAgentNameTest() {
	Assert.assertTrue(prop.ValidateAgentName());
	}
	
	@Test(priority=3)
	public void validateAgentPhNo() {
	Assert.assertTrue(prop.ValidatePhoneNumber());
	}
	
	

}
