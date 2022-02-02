Feature: Validating data in a Web Form

  Scenario Outline: Validate User is able to fill form from XML data sheet
    Given User is on clevermedia web form
    When User enters first name <FirstName> from XML data sheet
    And User enters last name <LastName> from XML data sheet
    And User enters zipcode <ZipCode> from XML data sheet
    And User enters message <Message> from XML data sheet
    And User clicks on submit button after entering all data from XML data sheet

    Examples: 
      | FirstName | LastName | ZipCode | Message |
      |         0 |        0 |       0 |       0 |
      |         1 |        1 |       1 |       1 |
      |         2 |        2 |       2 |       2 |