$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("src/test/java/features/GetPost.feature");
formatter.feature({
  "comments": [
    {
      "line": 1,
      "value": "#Background: List of steps run before each of the scenarios"
    },
    {
      "line": 2,
      "value": "#\"\"\" (Doc Strings)"
    },
    {
      "line": 3,
      "value": "#| (Data Tables)"
    },
    {
      "line": 4,
      "value": "#@ (Tags/Labels):To group Scenarios"
    },
    {
      "line": 5,
      "value": "#\u003c\u003e (placeholder)"
    },
    {
      "line": 6,
      "value": "#\"\""
    },
    {
      "line": 7,
      "value": "## (Comments)"
    },
    {
      "line": 8,
      "value": "#Sample Feature Definition Template"
    }
  ],
  "line": 9,
  "name": "Verify different GET operations using REST-assured",
  "description": "",
  "id": "verify-different-get-operations-using-rest-assured",
  "keyword": "Feature"
});
formatter.scenario({
  "line": 11,
  "name": "Verify one author of the post",
  "description": "",
  "id": "verify-different-get-operations-using-rest-assured;verify-one-author-of-the-post",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 12,
  "name": "Perform GET operation for \"/posts\"",
  "keyword": "Given "
});
formatter.step({
  "line": 13,
  "name": "Perform GET for post id \u003d \"2\"",
  "keyword": "And "
});
formatter.step({
  "line": 14,
  "name": "should obtain author \u003d \"Lasse Jova\"",
  "keyword": "Then "
});
formatter.match({
  "arguments": [
    {
      "val": "/posts",
      "offset": 27
    }
  ],
  "location": "GetPostSteps.perform_GET_operation_for(String)"
});
formatter.result({
  "duration": 128915400,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "2",
      "offset": 27
    }
  ],
  "location": "GetPostSteps.perform_GET_for_post_id(String)"
});
formatter.result({
  "duration": 2396946700,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "Lasse Jova",
      "offset": 24
    }
  ],
  "location": "GetPostSteps.should_obtain_author(String)"
});
formatter.result({
  "duration": 127200,
  "status": "passed"
});
formatter.scenario({
  "line": 16,
  "name": "Verify collection of authors of posts",
  "description": "",
  "id": "verify-different-get-operations-using-rest-assured;verify-collection-of-authors-of-posts",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 17,
  "name": "Perform GET operation for \"/posts\"",
  "keyword": "Given "
});
formatter.step({
  "line": 18,
  "name": "should obtain authors",
  "keyword": "Then "
});
formatter.match({
  "arguments": [
    {
      "val": "/posts",
      "offset": 27
    }
  ],
  "location": "GetPostSteps.perform_GET_operation_for(String)"
});
formatter.result({
  "duration": 125000,
  "status": "passed"
});
formatter.match({
  "location": "GetPostSteps.should_obtain_authors()"
});
formatter.result({
  "duration": 91494300,
  "status": "passed"
});
formatter.scenario({
  "line": 20,
  "name": "Verify Parameter of GET",
  "description": "",
  "id": "verify-different-get-operations-using-rest-assured;verify-parameter-of-get",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 21,
  "name": "Perform GET operation for \"/posts\"",
  "keyword": "Given "
});
formatter.step({
  "line": 22,
  "name": "Should obtain author for GET",
  "keyword": "Then "
});
formatter.match({
  "arguments": [
    {
      "val": "/posts",
      "offset": 27
    }
  ],
  "location": "GetPostSteps.perform_GET_operation_for(String)"
});
formatter.result({
  "duration": 87300,
  "status": "passed"
});
formatter.match({
  "location": "GetPostSteps.Should_obtain_author_for_GET()"
});
formatter.result({
  "duration": 157508100,
  "status": "passed"
});
formatter.scenario({
  "line": 24,
  "name": "Verify Parameter of Query",
  "description": "",
  "id": "verify-different-get-operations-using-rest-assured;verify-parameter-of-query",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 25,
  "name": "Perform GET operation for \"/posts\"",
  "keyword": "Given "
});
formatter.step({
  "line": 26,
  "name": "Should obtain authors number for GET",
  "keyword": "Then "
});
formatter.match({
  "arguments": [
    {
      "val": "/posts",
      "offset": 27
    }
  ],
  "location": "GetPostSteps.perform_GET_operation_for(String)"
});
formatter.result({
  "duration": 56500,
  "status": "passed"
});
formatter.match({
  "location": "GetPostSteps.Should_obtain_authors_number_for_GET()"
});
formatter.result({
  "duration": 66187400,
  "status": "passed"
});
formatter.scenario({
  "line": 28,
  "name": "Verify Post",
  "description": "",
  "id": "verify-different-get-operations-using-rest-assured;verify-post",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 29,
  "name": "Perform POST operation for \"/posts\"",
  "keyword": "Given "
});
formatter.match({
  "arguments": [
    {
      "val": "/posts",
      "offset": 28
    }
  ],
  "location": "GetPostSteps.Perform_POST_operation_for_POST(String)"
});
formatter.result({
  "duration": 518790900,
  "status": "passed"
});
formatter.scenario({
  "line": 32,
  "name": "Verify GET with bearer authentication token",
  "description": "",
  "id": "verify-different-get-operations-using-rest-assured;verify-get-with-bearer-authentication-token",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 33,
  "name": "Perform authentication for \"/auth/login\"",
  "rows": [
    {
      "cells": [
        "email",
        "password"
      ],
      "line": 34
    },
    {
      "cells": [
        "sitka@hotmail.com",
        "bajka123"
      ],
      "line": 35
    }
  ],
  "keyword": "Given "
});
formatter.step({
  "line": 36,
  "name": "Perform GET op for \"/posts/3\"",
  "keyword": "Given "
});
formatter.step({
  "line": 37,
  "name": "Author name is \"Naveem\"",
  "keyword": "Then "
});
formatter.match({
  "arguments": [
    {
      "val": "/auth/login",
      "offset": 28
    }
  ],
  "location": "GetPostSteps.Perform_authentication_for_with_body(String,DataTable)"
});
formatter.result({
  "duration": 58418900,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "/posts/3",
      "offset": 20
    }
  ],
  "location": "GetPostSteps.perform_GET_op_for(String)"
});
formatter.result({
  "duration": 34473400,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "Naveem",
      "offset": 16
    }
  ],
  "location": "GetPostSteps.author_name_is(String)"
});
formatter.result({
  "duration": 111333600,
  "status": "passed"
});
formatter.scenario({
  "line": 39,
  "name": "Verify GET with bearer authentication token for json schema validation",
  "description": "",
  "id": "verify-different-get-operations-using-rest-assured;verify-get-with-bearer-authentication-token-for-json-schema-validation",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 40,
  "name": "Perform authentication for \"/auth/login\"",
  "rows": [
    {
      "cells": [
        "email",
        "password"
      ],
      "line": 41
    },
    {
      "cells": [
        "sitka@hotmail.com",
        "bajka123"
      ],
      "line": 42
    }
  ],
  "keyword": "Given "
});
formatter.step({
  "line": 43,
  "name": "Perform GET op for \"/posts/3\"",
  "keyword": "Given "
});
formatter.step({
  "line": 44,
  "name": "Author name is \"Naveem\" with json validation",
  "keyword": "Then "
});
formatter.match({
  "arguments": [
    {
      "val": "/auth/login",
      "offset": 28
    }
  ],
  "location": "GetPostSteps.Perform_authentication_for_with_body(String,DataTable)"
});
formatter.result({
  "duration": 22545600,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "/posts/3",
      "offset": 20
    }
  ],
  "location": "GetPostSteps.perform_GET_op_for(String)"
});
formatter.result({
  "duration": 12258700,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "Naveem",
      "offset": 16
    }
  ],
  "location": "GetPostSteps.author_name_is_with_json_validation(String)"
});
formatter.result({
  "duration": 395327000,
  "status": "passed"
});
});