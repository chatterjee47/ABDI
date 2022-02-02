Feature: Validating a Web Form

  Scenario Outline: Validate User is able to fill form
    Given user is on clevermedia web form
    When user enters first name <FirstName>
    And user enters last name <LastName>
    And user enters zipcode <ZipCode>
    And user enters message <Message>
    And user clicks on submit

    Examples: 
      | FirstName | LastName | ZipCode | Message |
      |         0 |        0 |       0 |       0 |
      |         1 |        1 |       1 |       1 |
      |         2 |        2 |       2 |       2 |
