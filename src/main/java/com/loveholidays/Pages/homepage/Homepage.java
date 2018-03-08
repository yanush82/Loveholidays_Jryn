package com.loveholidays.Pages.homepage;

import com.loveholidays.Pages.utils.DriverSetting;
import com.sun.org.apache.bcel.internal.generic.RETURN;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/*
*     Janusz Ryn 23-02-2018
*/



public class Homepage {

    //Header
    //Newsletter section
    private @FindBy(css = ".col-xs-8.message-section") WebElement newsletterTeaser;
    private @FindBy(css = ".form-section .btn.btn-success.btn-sm") WebElement newsletterSignUpbutton;

    //Masthead
    private @FindBy(css = "#masthead .container") WebElement masteheadContainer;
    private @FindBy(css = ".logo.left") WebElement logoLeft;
    private @FindBy(css = ".masthead-badge.bookings-call") WebElement bookingCallIcon;
    private @FindBy(css = ".masthead-badge.atol-protected") WebElement atolProtectedIcon;
    private @FindBy(css = ".masthead-badge.abta-member") WebElement abtaMemberbutton;
    private @FindBy(css = ".masthead-badge.monthly-payments") WebElement monthlyPaymentsbutton;
    private @FindBy(css = ".masthead-badge.cogs") WebElement manageBookingbutton;

    //Mega-menu
    private @FindBy(css = ".mega-menu") WebElement megaMenu;
    private @FindBy(css = "#page-content") WebElement pageContent;

    //Footer
    private @FindBy(css = ".short-lists-wrapper.boot") WebElement footer;

    //Back To Offer
    private @FindBy(css = ".return-to-offer-large__details__destination") WebElement hotelLocation;
    private @FindBy(css = ".return-to-offer-large__details__name") WebElement hotelName;
    private @FindBy(css = ".homepage-desktop-layout__return-to-offer") WebElement backToOfferBanner;
    private @FindBy(css = ".return-to-offer-large__cta .custom-button") WebElement backToOfferButton;


    //Search
    private @FindBy(css = "#searchUnitDestinationInput") WebElement searchInputField;
    private @FindBy(css = ".select-list__list__element__span") WebElement selectPositionList;
    private @FindBy(css = ".search-unit-flight-and-hotel__cta__inner") WebElement searchButton;



    private String searchPharse = "spain"  ;


    public boolean isLogoDisplayed() {
        return DriverSetting.isElementPresent(logoLeft);
    }

    public boolean isMastheadDisplayed() {
        return DriverSetting.isElementPresent(masteheadContainer);
    }

    public boolean isHomepageLoaded() {
        return DriverSetting.isElementPresent(pageContent);
    }

    public String getHotelName() {
        return hotelName.getText();
    }

    public String getHotelLocation() {
        return hotelLocation.getText();
    }

    public String isBackToOfferBannerLoaded() {
       return DriverSetting.waitUntilLoaded(backToOfferBanner);
    }

    public void waitForActiveButton(){
        DriverSetting.waitUntilEnable(backToOfferButton);
    }

    public void backToOffer(){
        backToOfferButton.click();
    }


    public void SearchPharse()
    {
        searchInputField.sendKeys(searchPharse);
    }

    public void clickSearchButton()
    {
        searchButton.click();
    }

    public void waitForSearch()
    {
        DriverSetting.waitUntilLoaded(searchButton);
    }

    public void selectPositionFromList(){
        DriverSetting.waitUntilLoaded(selectPositionList);
        selectPositionList.click();
    }

}
