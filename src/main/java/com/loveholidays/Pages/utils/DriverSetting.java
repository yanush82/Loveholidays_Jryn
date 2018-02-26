package com.loveholidays.Pages.utils;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

/*
*     Janusz Ryn 23-02-2018
*/

public class DriverSetting {

    public static WebDriver driver;

    //static String baseUrl;
    public static String baseUrl = "https://www.loveholidays.com/";

    // Timeouts
    private static int shortTimeout = 60;
    private static int longTimeout = 120;

    public static void setWebdriver() throws Exception {

        // Firefox Driver - enable if you would like to verify in Firefox
        /*        System.setProperty("webdriver.gecko.driver","../Selenium/geckodriver");
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        */

        // Google Chrome Driver - enable if you would like to verify in Google Chrome
        System.setProperty("webdriver.chrome.driver", "../Selenium/chromedriver");
        DesiredCapabilities capabilities = DesiredCapabilities.chrome();

        capabilities.setCapability(CapabilityType.ForSeleniumServer.ENSURING_CLEAN_SESSION, true);
        capabilities.setCapability("chrome.switches", Arrays.asList("--incognito"));
        ChromeOptions options = new ChromeOptions();
        options.addArguments("disable-plugins");
        options.addArguments("disable-extensions");
        options.addArguments("test-type");
        options.addArguments("start-maximized");
        capabilities.setCapability(ChromeOptions.CAPABILITY, options);
        // test-type gets around chrome certificates issue --ignore-certificate-errors
        options.addArguments("test-type");
        driver = new ChromeDriver(options);
    }

    public static void assertLogTrue(boolean toAssert){
            try {
                if (toAssert) {
                    // do nothing
                } else {
                    throw new Exception();
                }
            } catch (Exception e){
                System.out.println("Assertion Failed" + e);
            }
        }

    // Saved time stamp used to get time differences

    private static Date savedTime;
    public static Date getCurrentDate(){
        return new Date();
    }

    public static String waitUntilLoaded(WebElement... elements) {
        List<WebElement> listOfPageElements = new ArrayList<WebElement>();
        for (WebElement element : elements) {
            listOfPageElements.add(element);
        }
        waitForVisibleElements(listOfPageElements, shortTimeout);
        return  "Success";
    }

    private static void waitForVisibleElements(List<WebElement> elements, int timeToWait) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, timeToWait);
            wait.until(ExpectedConditions.visibilityOfAllElements(elements));
        } catch (Exception e) {
            System.out.println("Exception" + (e));
        }
    }

    public static void waitUntilEnable(WebElement elements) {
        WebDriverWait wait = new WebDriverWait(driver, shortTimeout);
        wait.until(ExpectedConditions.elementToBeClickable(elements));
    }

    public static boolean isElementPresent(WebElement element) {
        boolean present = false;
        try {
            if (element.isDisplayed()) {
                present = true;
            }
        } catch (NoSuchElementException e) {
        }
        return present;
    }
}
