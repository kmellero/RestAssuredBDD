package steps;

import static io.restassured.RestAssured.*;
import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasSize;

import java.util.HashMap;

import org.hamcrest.core.Is;

import io.restassured.http.ContentType;

public class BDDStyleMethod {

	
	public static void SimpleGETPost(String postNumber) {
		given().contentType(ContentType.JSON)
		.when().get(String.format("http://localhost:3000/posts/%s", postNumber)).
		then().body("author", equalTo("Jonny B."));
	}
	
	public static void PerformContainerCollection() {
		given().contentType(ContentType.JSON)
		.when()
			.get(String.format("http://localhost:3000/posts"))
		.then()
		.body("author", containsInAnyOrder("Lasse Jova", "Jonny B.", null, "Naveem", "Łukasz M", "Dyik Xink")).statusCode(200);
		
	}
	
	public static void PerformPathParmeter() {
		given().contentType(ContentType.JSON)
		.with()
			.pathParams("post","2")
		.when()
			.get("http://localhost:3000/posts/{post}")
		.then()
			.body("author", containsString("Lasse Jova"));	
			
	}
	
	public static void PerformQueryParameter() {
		given()
			.contentType(ContentType.JSON)
			.queryParam("_page", "1").queryParam("_limit", "2")
		.when()
			.get("http://localhost:3000/posts")
		.then()
			.body("author", hasSize(2));
//		request: http://localhost:3000/posts?_page=1&_limit=2

	}
	
	public static void PerformPostWithBodyParameters() {
		HashMap<String, String> postContent = new HashMap<>();
		postContent.put("id", "7");
		postContent.put("title","Budyn Wan" );
		postContent.put("author","Krak Try");
		
		given().contentType(ContentType.JSON)
	.with()
		.body(postContent)
	.when()
		.post("http://localhost:3000/posts")
	.then()
		.body("author", Is.is("Krak Try"));
		
	}
	
}
