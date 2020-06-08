package steps;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;

//import io.cucumber.datatable.DataTable;
import cucumber.api.DataTable;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import io.restassured.response.Response;
import io.restassured.response.ResponseOptions;
import pojo.Location;
import pojo.Address;
import pojo.Posts;
import utilities.RestAssuredExtension;;

public class GetPostSteps {

	public static ResponseOptions<Response> response;

	@Given("^Perform GET operation for \"([^\"]*)\"$")
	public void perform_GET_operation_for(String url) throws URISyntaxException  {
		// remove comment when run w/o BDDStyleMethod  
		//given().contentType(ContentType.JSON);
		//response = RestAssuredExtension.GetOpsWithToken(url, response.getBody().jsonPath().get("access_token"));
	}

	@Given("^Perform GET op for \"([^\"]*)\"$")
	public void perform_GET_op_for(String url) throws URISyntaxException  {
		// remove comment when run w/o BDDStyleMethod  
		//given().contentType(ContentType.JSON);
		//response = RestAssuredExtension.GetOpsWithToken(url, response.getBody().jsonPath().get("access_token"));
		response = RestAssuredExtension.GetOps(url);
	
	}

	@And("^Perform GET for post id = \"([^\"]*)\"$")
	public void perform_GET_for_post_id(String postNumber)  {
		// remove comments when run w/o BDDStyleMethod class	
		//	when().get(String.format("http://localhost:3000/posts/%s", postNumber)).
		//		then().body("author", equalTo("Jonny B."));
		//comment when run the above
		BDDStyleMethod.SimpleGETPost("1");
	}

	@Then("^should obtain author = \"([^\"]*)\"$")
	public void should_obtain_author(String arg1)  {
		//then from RestAssured needs to follow when in the same method.  There are 2 BDD: cucumber & restAssured
	}

	@Then("^should obtain authors$")
	public void should_obtain_authors() {
		BDDStyleMethod.PerformContainerCollection();
	}
	
	@Then("^Should obtain author for GET$")
	public void Should_obtain_author_for_GET() {
		BDDStyleMethod.PerformPathParmeter();
	}
	
	@Then("^Should obtain authors number for GET$")
	public void Should_obtain_authors_number_for_GET() {
		BDDStyleMethod.PerformQueryParameter();
	}

	@Then("^Perform POST operation for \"([^\"]*)\"$")
//	@Then("^Perform POST operation$")
	public void Perform_POST_operation_for_POST(String arg0) {
		BDDStyleMethod.PerformPostWithBodyParameters();
	}

//	@Given("^Perform POST for \"([^\"]*)\" with body$")
//	public void  Perform_POST_for_with_body(String url, DataTable table) throws Throwable {
////Cucumber table data retrieve
//		
//	    List<Map<String, String>> data = table.asMaps(String.class, String.class);
//	    System.out.println("name: "+data.get(0).get("name")+", profileNo: "+data.get(0).get("profile"));
//	    HashMap<String, String> body = new HashMap<>();
//		body.put("name", data.get(0).get("name"));
//
//		HashMap<String, String> pathParams = new HashMap<>();
//		pathParams.put("profileNo", data.get(0).get("profile"));
//		System.out.println("profileNo is Empty?  "+pathParams.isEmpty());
//		
//////Perform POST
//	response = RestAssuredExtension.PostOpsWitBodyPathParams(url, pathParams, body);
//	}	
//	
//	@Then("^Body has name \"([^\"]*)\"$")
//	public void body_has_name(String name) throws Throwable {
//		
//		assertThat(response.getBody().jsonPath().get("name"), equalTo(name));
//	}
	@Given("^Perform authentication for \"([^\"]*)\"$")
	public void  Perform_authentication_for_with_body(String url, DataTable table) throws Throwable {
//Cucumber table data retrieve
		
	    List<Map<String, String>> data = table.asMaps(String.class, String.class);
	    System.out.println("email: "+data.get(0).get("email")+", password: "+data.get(0).get("password"));
	    HashMap<String, String> body = new HashMap<>();
	    body.put("email", data.get(0).get("email"));
		body.put("password", data.get(0).get("password"));

		
//Perform authentication POST
	response = RestAssuredExtension.PostOpsWithBody(url, body);
	}	
	
	@Then("^Author name is \"([^\"]*)\"$")
	public void author_name_is(String authorName) throws Throwable {
		
		Posts posts = response.getBody().as(Posts.class);

		assertThat(posts.getAuthor(), equalTo(authorName));

//		assertThat(response.getBody().jsonPath().get("author"), hasItem("Jonny B."));
			
	}
	
	@And("^Perform GET op for address \"([^\"]*)\"$")
	public void perform_GET_op_for_address(String url, DataTable table) throws Throwable {
//Cucumber table data retrieve
		
	    List<Map<String, String>> data = table.asMaps(String.class, String.class);
	    HashMap<String, String> queryParams = new HashMap<>();
	    queryParams.put("id", data.get(0).get("id"));
	    System.out.println("queryParams: "+queryParams.toString());
	    
	    //response
	    response = RestAssuredExtension.GetOpsWithQueryParamsWithToken(url, queryParams, response.getBody().jsonPath().getString("access_token"));

		

	}

	@Then("^Street name is \"([^\"]*)\" for the \"([^\"]*)\" address$")
	public void street_name_is_for_address(String streetName, String type) throws Throwable {

		Location[] location = response.getBody().as(Location[].class);
		//filter the address based on the type of address e.g. primary or secondary
		Address address = location[0].getAddress().stream().filter(x-> x.getType().equalsIgnoreCase(type)).findFirst().orElse(null);

		assertThat(address.getStreet(), equalTo(streetName));
	}
	
	
	@Then("^Author name is \"([^\"]*)\" with json validation$") 
	public void author_name_is_with_json_validation(String authorName) throws Throwable {
		
//returns the body as string
		String responseBody = response.getBody().asString();

		assertThat(responseBody, matchesJsonSchemaInClasspath("post.json"));
		//weird; post.json has id as string while in db.json (with all posts) id is integer
		//run json-server .\db.json  

//		assertThat(response.getBody().jsonPath().get("author"), hasItem("Jonny B."));
			
	}	
}
