Feature: DeletePosts
	Test to delete operation
	
	
Scenario: Verify DELETE after POST
Given Perform POST for "/posts" with body as
| id | title | author |
| 8 | Executive decision | Platon |
And Perform DELETE for "/posts/{postid}/"
| postid |
| 8 | 
And Perform GET with path parameter for "/posts/{postid}/"
| postid |
| 8 |
Then Body with "no" such title "Executive decision"