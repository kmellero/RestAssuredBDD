package steps;

import io.restassured.response.ResponseOptions;
import utilities.RestAssuredExtension;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hamcrest.core.Is;
import org.hamcrest.core.IsNot;

import cucumber.api.DataTable;
import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import io.restassured.response.Response;

public class POSTSteps {

	
	public static ResponseOptions<Response> response;
	
	@Given("^Perform POST for \"([^\"]*)\" with body$")
	public void  Perform_POST_for_with_body(String url, DataTable table) throws Throwable {
//Cucumber table data retrieve
		
	    List<Map<String, String>> data = table.asMaps(String.class, String.class);
	    System.out.println("name: "+data.get(0).get("name")+", profileNo: "+data.get(0).get("profile"));
	    HashMap<String, String> body = new HashMap<>();
		body.put("name", data.get(0).get("name"));

		HashMap<String, String> pathParams = new HashMap<>();
		pathParams.put("profileNo", data.get(0).get("profile"));
		System.out.println("profileNo is Empty?  "+pathParams.isEmpty());
		
////Perform POST
		response = RestAssuredExtension.PostOpsWithBodyPathParams(url, pathParams, body);
	}	
	
	@Then("^Body has name \"([^\"]*)\"$")
	public void body_has_name(String name) throws Throwable {
		
	 	assertThat(response.getBody().jsonPath().get("name"), equalTo(name));
	}

	@Given("^Perform POST for \"([^\"]*)\" with body as$")
	public void perform_POST_for_with_body_as(String url, DataTable table) throws Throwable {
	    List<Map<String, String>> data = table.asMaps(String.class, String.class);
	    System.out.println("id: "+data.get(0).get("id")+", title: "+data.get(0).get("title")+ ", author: "+data.get(0).get("author"));
	   
	    HashMap<String, String> body = new HashMap<>();
		body.put("id", data.get(0).get("id"));
		body.put("title", data.get(0).get("title"));
		body.put("author", data.get(0).get("author"));
	// perform POST 
		RestAssuredExtension.PostOpsWithBody(url, body);

	}

	@Given("^Perform DELETE for \"([^\"]*)\"$")
	public void perform_DELETE_for(String url, DataTable table) throws Throwable {
	
	    List<Map<String, String>> data = table.asMaps(String.class, String.class);
	    System.out.println("DELETE, postId: "+data.get(0).get("postid"));

	    HashMap<String, String> pathParams = new HashMap<>();
		pathParams.put("postid", data.get(0).get("postid"));
		System.out.println("DELETE, Is postId Empty?  "+pathParams.isEmpty());
		
	// perform DELETE
		RestAssuredExtension.DeleteOpsWithPathParams(url, pathParams);
		
	}

	@Given("^Perform GET with path parameter for \"([^\"]*)\"$")
	public void perform_GET_with_path_parameter_for(String url, DataTable table) throws Throwable {

	    List<Map<String, String>> data = table.asMaps(String.class, String.class);
	    System.out.println("GET, postId: "+data.get(0).get("postid"));

	    HashMap<String, String> pathParams = new HashMap<>();
		pathParams.put("postid", data.get(0).get("postid"));
//		System.out.println("Is postId Empty?  "+pathParams.isEmpty());
		System.out.println("postId"+pathParams.get("postid").toString());
		
	// perform GET for a deleted post
		response = RestAssuredExtension.GetOpsWithPathParams(url, pathParams);
		System.out.println("breakpoint ");
	}

	@Then("^Body with \"([^\"]*)\" such title \"([^\"]*)\"$")         // first string either "no" or null
	public void body_with_such_title(String condition, String title) throws Throwable {
		
		if (condition.equalsIgnoreCase("no"))
			assertThat(response.getBody().jsonPath().get("title"), IsNot.not(title));
		else
			assertThat(response.getBody().jsonPath().get("title"), Is.is(title));

	}
	@Given("^Perform PUT for \"([^\"]*)\"$")
	public void perform_PUT_for(String url, DataTable table) throws Throwable {

	    List<Map<String, String>> data = table.asMaps(String.class, String.class);
	    System.out.println("PUT, Id: "+data.get(0).get("id"));

	    HashMap<String, String> body = new HashMap<>();
		body.put("id", data.get(0).get("id"));
		body.put("title", data.get(0).get("title"));
		body.put("author", data.get(0).get("author"));
		
	    HashMap<String, String> pathParams = new HashMap<>();
	    pathParams.put("postid", data.get(0).get("id"));
		
	// perform PUT 
		RestAssuredExtension.PUTOpsWithBodyAndPathParams(url, body, pathParams);


	}	
	
}
