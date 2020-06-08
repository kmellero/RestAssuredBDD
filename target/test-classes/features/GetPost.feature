#Background: List of steps run before each of the scenarios
#""" (Doc Strings)
#| (Data Tables)
#@ (Tags/Labels):To group Scenarios
#<> (placeholder)
#""
## (Comments)
#Sample Feature Definition Template
Feature: Verify different GET operations using REST-assured

Scenario: Verify one author of the post
	Given Perform GET operation for "/posts"
	And Perform GET for post id = "2"
	Then should obtain author = "Lasse Jova"
	
Scenario: Verify collection of authors of posts
	Given Perform GET operation for "/posts"
	Then should obtain authors
	
Scenario: Verify Parameter of GET
	Given Perform GET operation for "/posts"
	Then Should obtain author for GET

Scenario: Verify Parameter of Query
	Given Perform GET operation for "/posts"
	Then Should obtain authors number for GET	
	
Scenario: Verify Post
	Given Perform POST operation for "/posts"
		

Scenario: Verify GET with bearer authentication token
Given Perform authentication for "/auth/login" 
| email 		   | password |
|sitka@hotmail.com | bajka123 |
Given Perform GET op for "/posts/3"
Then Author name is "Naveem"

Scenario: Verify GET with bearer authentication token for json schema validation
Given Perform authentication for "/auth/login" 
| email 		   | password |
|sitka@hotmail.com | bajka123 |
Given Perform GET op for "/posts/3"
Then Author name is "Naveem" with json validation


	