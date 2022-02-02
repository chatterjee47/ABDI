Feature: Validating data in a Web Form

  Scenario Outline: Validate User is able to fill form from XML data sheet
    Given User is on clevermedia web form
    When User enters first name <FirstName>
    And User enters last name <LastName>
    And User enters zipcode <ZipCode>
    And User enters message <Message>
    And User clicks on submit

    Examples: 
      | FirstName | LastName | ZipCode | Message |
      |         0 |        0 |       0 |       0 |
      |         1 |        1 |       1 |       1 |
      |         2 |        2 |       2 |       2 |