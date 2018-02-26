package com.loveholidays.Pages.bookingPage;

import com.loveholidays.Pages.utils.DriverSetting;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/*
*     Janusz Ryn 23-02-2018
*/

public class BookingPage {

    private @FindBy(css = ".book-layout__wrap") WebElement pageContent;
    private @FindBy(css = ".book-progress-steps") WebElement bookProgressStepsBar;
    private @FindBy(css = ".book-header-layout__inner__wrap .book-header-layout__logo") WebElement loveHolidaysLogo;
    private @FindBy(css = ".book-layout__basket") WebElement bookBasket;
    private  @FindBy(css = ".book-basket__hotel-details__name") WebElement hotelName;
    private @FindBy(css = ".book-basket__hotel-details__destination") WebElement hotelLocation;
    private @FindBy(css = ".notifications-layout") WebElement sessionExpiredNotification;
    private @FindBy(css = ".notifications-layout__close") WebElement closeNotificationButton;

    public void waitForBookBasket()
    {
        DriverSetting.waitUntilLoaded(bookBasket);
    }

    public boolean isBookingPageContentLoaded() {
        return DriverSetting.isElementPresent(pageContent);
    }

    public boolean isLogoLoaded() {
        return DriverSetting.isElementPresent(loveHolidaysLogo);
    }

    public void closingNotification(){
        if (DriverSetting.isElementPresent(sessionExpiredNotification))
        {
            closeNotificationButton.click();
        }
    }

    public String getHotelLocation() {
        return hotelLocation.getText();
    }

    public String getHotelName() {
        return hotelName.getText();
    }

    public void goToHomepage(){
        loveHolidaysLogo.click();
    }

}
