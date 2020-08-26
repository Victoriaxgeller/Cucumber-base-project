@SmokeFeature
Feature: Feature to test google search functionality

  @smokeTest
  Scenario: Validate google search is working

    Given browser is open
    And user is on google search page
    When user enters a text in search box
    And hits enter
    Then user is navigated to search results
    And search results count is more then 360000000

#  <results count>
#
#    Example:

