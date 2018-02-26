Feature: Redirections

  Scenario: Banner redirected to the landing page
    Given Booking page displayed
    And User clicks on LoveHolidays Logo
    And Homepage is displayed
    When User clicks on back to offer button
    Then Booking page displayed again

