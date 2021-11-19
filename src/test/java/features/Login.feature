@LoginFeature
Feature: Login Feature

  Background: Open the Login Page
    Given User has navigated to the Login Page

  @Regression @Sanity
  Scenario: Positive Login Scenario
    When User enters correct Username and Password
    And User clicks on the Login Button
    Then User Should be navigated to the Home Page

	@Regression
  Scenario: Positive Login Scenario with Parameters
    When User enters correct Username "user2@domain.com" and Password "Adz@85o2t"
    And User clicks on the Login Button
    Then User Should be navigated to the Home Page

  Scenario Outline: Positive Login Scenario with Cucumber Datatable
    When User enters correct Username "<Username>" and Password "<Password>"
    And User clicks on the Login Button
    Then User Should be navigated to the Home Page

    Examples: 
      | Username         | Password  |
      | user3@domain.com | Afz@74o3t |
      | user4@domain.com | Ahz@63o4t |

  Scenario Outline: Negative Login Scenario with Multiple Users
    When User enters correct Username "<Username>" and Password "<Password>"
    And User clicks on the Login Button
    Then User Should be getting error message "<Error>"

    Examples: 
      | Username         | Password  | Error                                              |
      | user5@domain.com | Ajz@52o5t | The email or password you have entered is invalid. |
      | user6@domain.com | Alz@41o6t | The email or password you have entered is invalid. |

  @DataTable
  Scenario: Positive Login Scenario with Parameters
    When User enters correct Crienditals
      | Field    | Value            |
      | Username | user7@domain.com |
      | Password | Anz@30o7t        |
    And User clicks on the Login Button
    Then User Should be navigated to the Home Page
