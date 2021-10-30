Feature: New user Registration

  Background:
    Given the user is on the homepage
    When the user clicks "JOIN NOW! in the top right corner" button
    Then the user validates that they are on the Sign up page
    When the user enters valid data on the registration form
      | Field      | Details                            |
      | Title      | Mr                                 |
      | FirstName  | Jason                              |
      | SurName    | Bourne                             |
      | DOB        | 05-05-1995                         |
      | email      | jbourne@mail.com                   |
      | Telephone  | 555-555-5555                       |
      | Mobile     | 995-555-5555                       |
      | Address1   | 59 A st.                           |
      | Address2   |                                    |
      | City       | Miami                              |
      | County     | Miami-Dade                         |
      | Postcode   | 33101                              |
      | Country    | USA                                |
      | UserName   | jbourne                            |
      | SecurityQ1 | What was your childhood's nickname |
      | Answer1    | Can't remember                     |
      | SecurityQ2 | What is your favorite sport        |
      | Answer2    | Boxing                             |
      | Currency   | US Dollars                         |
    And the user checks the tickbox and accepts Terms and Conditions, certifies being of age


  Scenario Outline: Password must be at least 6 characters long

    When the user enters "<password>"
    When the user retypes password
    And the user clicks "JOIN NOW!" button
    Then the user validates "<message>" with text that appears under the choose password box

    Examples:
      | password | message                            |
      | Bou@0    | The minimum length is 6 characters |
      |          | This field is required             |


  Scenario Outline: Password must be at least 6 characters long with at least one number and at least one special character

    When the user enters "<password>"
    When the user retypes password
    And the user clicks "JOIN NOW!" button
    Then the user validates message with text "Confirm password required"

    Examples:
      | password                                                                                               |
      | bourne!1                                                                                               |
      | 1bourne!                                                                                               |
      | !1bourne                                                                                               |
      | bourne!                                                                                                |
      | 1bourne                                                                                                |
      | 555%%$$                                                                                                |
      | mrbourne                                                                                               |
      | 555000                                                                                                 |
      | !@$&*%'                                                                                                |
      | !@$&*%'`#^*()-+=~<>?/:;{.}5bourne                                                                      |
      | 555%%%b                                                                                                |
      | bbbbbbbbbbbbbbbbbboooooooooouuuuuuuuuuuuuuuurrrrrrrrrrrrnnnnnnnnnneeeeeeeeee5555555555555!!!!!!!!!!!!! |
      | BOURNE5$                                                                                               |
      | +++bourne1                                                                                             |
      | --bourne1                                                                                              |
      |   bourne  ?1                                                                                            |



