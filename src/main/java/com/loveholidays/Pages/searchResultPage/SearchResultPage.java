package com.loveholidays.Pages.searchResultPage;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

/**
 * Created by Janusz Ryn on 06/03/2018
 */

public class SearchResultPage {

    private @FindBy(css = ".search-results-card-desktop__content") List<WebElement> searchResultEntryList;



    public void getNumberOfSearchResults(){
        searchResultEntryList.size();
        System.out.println("Number of results" + searchResultEntryList.size());

    }
    }



