package com.zoopla.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.zoopla.BaseClass.BaseClass;

public class AgentDetailsPage extends BaseClass {
	
	
	@FindBy(xpath="//div[@id='content']/div/h1")
	private WebElement AgentDetails;
	
	
	public AgentDetailsPage() {
		PageFactory.initElements(driver, this);
	}

	public String AgentDetails() {
		return AgentDetails.getText();
	}
}
