package com.rajesh.stepDefinitions;

import org.junit.Assert;

import com.rajesh.factory.DriverFactory;
import com.rajesh.pages.LoginPage;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginPageSteps {
	
	private LoginPage loginPage = new LoginPage(DriverFactory.getDriver());
	private static String actualTitle;
	
	@Given("user is on login page")
	public void user_is_on_login_page() {
		DriverFactory.getDriver().get("http://automationpractice.com/index.php?controller=authentication&back=my-account");
	}

	@When("user reads the title of the page")
	public void user_reads_the_title_of_the_page() {
		actualTitle = loginPage.getLoginPageTitle();
		System.out.println("Page title is :" + actualTitle);
	}

	@Then("page title should be {string}")
	public void page_title_should_be(String expectedTitle) {
		Assert.assertTrue(expectedTitle.equals(actualTitle));
	}

	@Then("forgot password link should be displayed")
	public void forgot_password_link_should_be_displayed() {
		Assert.assertTrue(loginPage.isForgotPasswordLinkExist());
	}

	@When("user enters username {string}")
	public void user_enters_username(String userName) {
		loginPage.enterUserName(userName);
	}

	@When("user enters password {string}")
	public void user_enters_password(String pwd) {
		loginPage.enterPassword(pwd);
	}

	@When("user clicks on login button")
	public void user_clicks_on_login_button() {
		loginPage.clickOnLogin();
	}	
}
