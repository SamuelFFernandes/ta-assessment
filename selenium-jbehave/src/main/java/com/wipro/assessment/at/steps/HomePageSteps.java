package com.wipro.assessment.at.steps;

import org.jbehave.core.annotations.Composite;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Named;
import org.jbehave.core.annotations.When;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.wipro.assessment.at.pages.HomePage;

@Component
public class HomePageSteps extends AbstractSteps {

	@Autowired
	private HomePage homePage;
	
	@Given("I am on google page")
	public void IAmOnGooglePage() {
		homePage.navigateTo();
	}
	
	@When("I search for '$search'")
	public void ISearchFor(@Named("search") String search) {
		homePage.search(search);
	}
	
	@When("I click on search button")
	public void IClickOnSearchButton() {
		homePage.clickSearch();
	}
	
	
	@Given("I searched on google for '$search'")
	@Composite(steps = {
			"Given I am on google page",
			"When I search for '$search'",
			"When I click on search button"})
	public void ISearchedOnGoogleFor(@Named("search") String search) {

	}
}
