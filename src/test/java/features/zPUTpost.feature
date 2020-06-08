Feature: Verify PUT  post operation

Scenario: Verify PUT after POST
Given Perform POST for "/posts" with body as
| id | title | author |
| 8 | Executive decision | Platon |
And Perform PUT for "/posts/{postid}/"
| id | title | author |
| 8 | Panstwo | Platon | 
And Perform GET with path parameter for "/posts/{postid}/"
| postid |
| 8 |
Then Body with "" such title "Panstwo"