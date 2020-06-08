Feature: Verify different POST operations using REST-assured


Scenario: Verify Post operation for Profile
	Given Perform POST for "/post/{profileNo}/profile" with body
	| name | profile |
	| Samm | 1 |
	Then Body has name "Samm"	
