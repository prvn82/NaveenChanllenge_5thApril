package com.zoopa.TestCases;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import com.zoopla.BaseClass.BaseClass;
import com.zoopla.pages.Zoopa_HomePage;


 /*TestDetails: 1. Validating Homepage details
             2. Entering SearchKey London and Validate response*/



public class HomePageTests extends BaseClass {
	
	private Zoopa_HomePage Homapge;
	
	
	@BeforeClass
	public void init() {
		Homapge=new Zoopa_HomePage();
	}
	
	@Test(priority=1)
	public void ValidateHomePagetitle() {
		Homapge.ValidateTiltle();
	}
	
	@Test(priority=2,dependsOnMethods="ValidateHomePagetitle")
	public void EnterSearchTest() {
		
		Homapge.EnterSearch();
		
	}

}
