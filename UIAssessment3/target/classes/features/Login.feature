Feature: Test the log in page.
#correct_login_details
  Scenario: Test login using correct login details.
    Given user is on the login page
    When user enters correct username and correct password
    And clicks on the login button
    Then user should be navigated to the inventory page
#incorrect_login_details
  Scenario: Test login using incorrect login details.
    Given user is on the login page
    When user enters incorrect username and incorrect password
    And clicks on the login button
    Then user should not be able to login
#empty username and correct password
  Scenario: Test login using incorrect login details.
    Given user is on the login page
    When user enters incorrect username and incorrect password
    And clicks on the login button
    Then user should not be able to login
#incorrect username and correct password
  Scenario: Test login using incorrect login details.
    Given user is on the login page
    When user enters incorrect username and incorrect password
    And clicks on the login button
    Then user should not be able to login
  #correct username and incorrect password
  Scenario: Test login using incorrect login details.
    Given user is on the login page
    When user enters incorrect username and incorrect password
    And clicks on the login button
    Then user should not be able to login
    #correct username and empty password
  Scenario: Test login using incorrect login details.
    Given user is on the login page
    When user enters incorrect username and incorrect password
    And clicks on the login button
    Then user should not be able to login



