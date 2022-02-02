Feature: Validate Web Form

  Scenario Outline: Validate User is able to fill form
    Given User is on clevermedia web form page
    When User fills the form from a given sheetname "<SheetName>" and rownumber <RowNumber>
    And User clicks on submit button
    Then User should be able to submit form successfully

    Examples: 
      | SheetName | RowNumber |
      | Form      |         0 |
     
