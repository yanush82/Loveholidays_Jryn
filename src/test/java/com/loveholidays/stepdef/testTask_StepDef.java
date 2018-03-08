package com.loveholidays.stepdef;

import com.loveholidays.Pages.homepage.*;

import com.loveholidays.Pages.bookingPage.BookingPage;
import com.loveholidays.Pages.searchResultPage.SearchResultPage;
import com.loveholidays.Pages.utils.DriverSetting;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

/*
*     Janusz Ryn 23-02-2018
*/

public class testTask_StepDef {

    private Homepage homepage;
    private BookingPage bookingPage;
    private SearchResultPage searchResultPage;
    private WebDriver driver;
    private String baseUrl;
    private boolean acceptNextAlert = true;
    private StringBuffer verificationErrors = new StringBuffer();
    private String bookingPgHotelName;
    private String bookingPgHotelLocation;
    private String homePgHotelName;
    private String homePgHotelLocation;

    public testTask_StepDef() throws Exception{
        this.baseUrl = DriverSetting.baseUrl;
        DriverSetting.setWebdriver();
        this.driver = DriverSetting.driver;
        homepage = PageFactory.initElements(driver, Homepage.class);
        bookingPage = PageFactory.initElements(driver, BookingPage.class);
        searchResultPage = PageFactory.initElements(driver, SearchResultPage.class);

    }

    @Given("^Booking page displayed$")
    public void booking_page_displayed() throws Throwable {
        driver.get(baseUrl + "book/flight-and-hotel/offer-summary.html?shortref=LA9YVPJH&state=AwoUKFAAIKSCaCeCjLYYEIABgHA");
        Thread.sleep(7000); //Lot of page reload happens on booking page
        bookingPage.closingNotification();
        bookingPage.waitForBookBasket();
        bookingPage.isBookingPageContentLoaded();
        bookingPage.isLogoLoaded();
        this.bookingPgHotelLocation = bookingPage.getHotelLocation();
        this.bookingPgHotelName = bookingPage.getHotelName();
    }

    @And("^User clicks on LoveHolidays Logo$")
    public void user_clicks_on_LoveHolidays_Logo() throws Throwable {
        bookingPage.goToHomepage();
    }

    @And("^Homepage is displayed$")
    public void homepage_is_displayed() throws Throwable {
        homepage.waitForActiveButton();
        homepage.isHomepageLoaded();
        homepage.isMastheadDisplayed();
        homepage.isLogoDisplayed();
        homepage.isBackToOfferBannerLoaded();
        homepage.isBackToOfferBannerLoaded();
        this.homePgHotelLocation = homepage.getHotelLocation();
        this.homePgHotelName = homepage.getHotelName();
        Assert.assertEquals(bookingPgHotelName,homepage.getHotelName());
        Assert.assertEquals(bookingPgHotelLocation,homepage.getHotelLocation());
    }

    @When("^User clicks on back to offer button$")
    public void user_clicks_on_back_to_offer_button() throws Throwable {
       homepage.backToOffer();
       Thread.sleep(2000);
       bookingPage.availabilityPagePassing();
    }

    @Then("^Booking page displayed again$")
    public void booking_page_displayed_again() throws Throwable {
        bookingPage.closingNotification();
        bookingPage.waitForBookBasket();
        bookingPage.isBookingPageContentLoaded();
        bookingPage.isLogoLoaded();
        this.bookingPgHotelLocation = bookingPage.getHotelLocation();
        this.bookingPgHotelName = bookingPage.getHotelName();
        Assert.assertEquals(homePgHotelName,bookingPage.getHotelName());
        Assert.assertEquals(homePgHotelLocation,bookingPage.getHotelLocation());
        tearDown();
    }
    @After
     public void tearDown() throws Exception {
        driver.quit();
    }

    @Given("^Homepage opened$")
    public void homepage_opened() throws Throwable {
        driver.get(baseUrl);
        homepage.waitForSearch();
        homepage.isLogoDisplayed();
    }

    @And("^User populates search$")
    public void user_populates_search() throws Throwable {
        homepage.SearchPharse();
        homepage.selectPositionFromList();
        Thread.sleep(1000);
    }

    @When("^User clicks on search button$")
    public void user_clicks_on_search_button() throws Throwable {
        homepage.clickSearchButton();
        Thread.sleep(1000);
        homepage.clickSearchButton();
    }

    @Then("^Search result page displayed$")
    public void search_result_page_displayed() throws Throwable {
        searchResultPage.getNumberOfSearchResults();

    }

    @And("^Number of elements is (\\d+)$")
    public void number_of_elements_is(int arg1) throws Throwable {
        tearDown();
    }


}
