@registration
Feature: New user registration

  Scenario: user should be able to register as a new player using full details
    Given the user is on the home page
    And the user clicks "JOIN NOW! on the home page" button
    Then the user validates that they are on the Sign up page
    When the user selects "Miss" title from the dropdown menu
    When the user enters first name and surname
      | firstname | Olessya |
      | surname   | Foxborn |
    When the user checks the tickbox with text "I accept the Terms and Conditions and certify that I am over the age of 18."
    And the user clicks "JOIN NOW! on the sign up page" button
    Then the user validates that a validation message with text "This field is required" appears under the date of birth box


