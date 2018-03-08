Feature: Redirections

  @Banner
  Scenario: Banner redirected to the landing page
    Given Booking page displayed
    And User clicks on LoveHolidays Logo
    And Homepage is displayed
    When User clicks on back to offer button
    Then Booking page displayed again

    @SearchResults
  Scenario: 25 search results returned
    Given Homepage opened
    And User populates search
    When User clicks on search button
    Then Search result page displayed
    And Number of elements is 25


