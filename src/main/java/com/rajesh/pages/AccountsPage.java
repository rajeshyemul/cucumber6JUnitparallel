package com.rajesh.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AccountsPage {

	private WebDriver driver;
	private By accountSections = By.cssSelector("div#center_column span");
	
	public AccountsPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public int getAccounsSectionCount() {
		return driver.findElements(accountSections).size();
	}
	
	public List<String> getAccountsSectionList() {
		List<String> accountList = new ArrayList<>();
		List<WebElement> accountHeaderList = driver.findElements(accountSections);
		
		for(WebElement element: accountHeaderList) {
			System.out.println(element.getText());
			accountList.add(element.getText());
		}
		return accountList;
	}
	
	public String getAccountPageTitle() {
		return driver.getTitle();
	}
}
