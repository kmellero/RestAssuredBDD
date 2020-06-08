Feature: CompelexDataGET
	Verify complex data
	
Scenario: Verify GET with bearer authentication token
Given Perform authentication for "/auth/login" 
| email 		   | password |
|sitka@hotmail.com | bajka123 |
And Perform GET op for address "/location/"
| id |
| 1 |
Then Street name is "1st street" for the "primary" address
