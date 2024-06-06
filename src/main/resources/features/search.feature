Feature: Google search

  Scenario: Searching with google search bar
    Given User is on the google search page
    When User try to search any keywords
    Then User should be redirected to result page
    And User can see the result
