Feature: Validate Web Form

Scenario: Validate User is able to fill form
META-DATA: {"dataProvider":"dp", "dataProviderClass":"testUtility.DataProviderJson","description":"Data driven test that uses custom data provider"}

Given user is on clevermedia web form
When user enters first name '<firstname>'   
And user enters last name '<lastname>'
And user enters zipcode '<zipcode>'
And user enters message '<message>'
And user clicks on submit 
Then user should be able to submit form successfully





	
			