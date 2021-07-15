package com.rajesh.stepDefinitions;

import java.util.List;
import java.util.Map;

import org.junit.Assert;

import com.rajesh.factory.DriverFactory;
import com.rajesh.pages.AccountsPage;
import com.rajesh.pages.LoginPage;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class MyAccountPageSteps {
	
	private LoginPage loginPage = new LoginPage(DriverFactory.getDriver());
	private AccountsPage accountPage;
	
	@Given("user has already logged in to the application")
	public void user_has_already_logged_in_to_the_application(DataTable credentialTable) {
		List<Map<String, String>> credInfo = credentialTable.asMaps();
		String userName = credInfo.get(0).get("username");
		String password = credInfo.get(0).get("password");
		
		DriverFactory.getDriver().get("http://automationpractice.com/index.php?controller=authentication&back=my-account");
		accountPage = loginPage.doLogin(userName, password);
		
	}

	@Given("user is on Accounts page")
	public void user_is_on_accounts_page() {
		String pageTitle = accountPage.getAccountPageTitle();
		System.out.println(pageTitle);
	}

	@Then("user reads Accounts section")
	public void user_reads_accounts_section(DataTable sectionTable) {
		List<String> expectedAccountSectioList = sectionTable.asList();
		System.out.println(expectedAccountSectioList);
		
		List<String> actualAccountSectioList = accountPage.getAccountsSectionList();
		System.out.println(actualAccountSectioList);
		
		Assert.assertTrue(actualAccountSectioList.containsAll(expectedAccountSectioList));
	}

	@Then("Accounts sections count should be {int}")
	public void accounts_sections_count_should_be(Integer expectedCount) {
		Assert.assertTrue(accountPage.getAccounsSectionCount() == expectedCount);
	}

}
