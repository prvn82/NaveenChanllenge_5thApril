package com.zoopa.TestCases;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.zoopla.BaseClass.BaseClass;
import com.zoopla.pages.AgentDetailsPage;
import com.zoopla.pages.PropertPage;
import com.zoopla.pages.SearchPage;
import com.zoopla.pages.Zoopa_HomePage;


//Test Details : 1. Validating if correct agent details are opened.

public class AgentDetailsPageTest extends BaseClass {
	
	
	private Zoopa_HomePage Homapge;
	 private SearchPage search;
	 private PropertPage prop;
	 private AgentDetailsPage agent;
	 
	 private String agentName;
	
	
	@BeforeClass
	public void init() {
		
		System.out.println("**************");
		Homapge=new Zoopa_HomePage();
		search=Homapge.EnterSearch();
		prop=search.ClickOnProperty();
		agentName=prop.AgentName();
		agent=prop.AgentDetails();
	}
	
	@Test
	public void ValidateAgentName() {
		System.out.println(agentName);
		if(agent.AgentDetails().contains(agentName)) {
			Assert.assertTrue(true);
		}
		else {
			Assert.assertFalse(true, "Agent Name is not matching");
		}
	}

}
