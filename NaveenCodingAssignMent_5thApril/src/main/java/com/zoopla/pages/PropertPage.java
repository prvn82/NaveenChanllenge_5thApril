package com.zoopla.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.zoopla.BaseClass.BaseClass;

public class PropertPage extends BaseClass {

	
	@FindBy(xpath="//div[@class='dp-sidebar-wrapper__contact']//div[@class='ui-agent']/a/div[@class='ui-agent__logo']/img")
	private WebElement Agent_logo;
	
	
	@FindBy(xpath="//div[@class='dp-sidebar-wrapper__contact']//div[@class='ui-agent']/a/div[@class='ui-agent__text']/h4")
	private WebElement AgentName;
	
	@FindBy(xpath="//div[@class='dp-sidebar-wrapper__contact']//div[@class='ui-agent']/p[@class='ui-agent__tel ui-agent__text']/a")
	private WebElement phoneNumber;
	
	
	
	public PropertPage() {
		PageFactory.initElements(driver, this);
	}
	
	public void PrintAgentDetaisl() {
		System.out.println(Agent_logo.getAttribute("alt"));
		System.out.println(AgentName.getText());
		System.out.println(phoneNumber.getText());


	}
	public boolean ValidateLogo() {
		return Agent_logo.isDisplayed();
	}
	
	public boolean ValidateAgentName() {
		return AgentName.isDisplayed();
	}
	
	public boolean ValidatePhoneNumber() {
		return phoneNumber.isDisplayed();
	}
	
	public AgentDetailsPage AgentDetails() {
		AgentName.click();
		return new AgentDetailsPage();
	}
	
	public String AgentName() {
		return AgentName.getText();
	}
}
