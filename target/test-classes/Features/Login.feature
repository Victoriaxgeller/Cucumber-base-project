@SmokeFeature
Feature: Feature to test login functionality

  @smokeTest
  Scenario Outline: Check login is successful with valid credentials

    Given user is on login page
    When user enters <username> and <password>
    And clicks on login button
    Then user is navigated to the url '/matches'
    Examples:
      | username | password |
      | Viktoriia.korda@gmail.com | 12345 |
#      | vika.smile1993@mail.ru | 123 |
#      | vika_baranika@ha.ha | 123 |

