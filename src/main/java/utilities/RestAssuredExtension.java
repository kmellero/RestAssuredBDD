package utilities;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.Map;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.http.Header;
import io.restassured.response.Response;
import io.restassured.response.ResponseOptions;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;


public class RestAssuredExtension {

	public  static RequestSpecification request;
	//public  static RequestSpecification requestSpec; 
	public static ResponseSpecification response;
	
	public RestAssuredExtension() {
		
		//Arrange
		RequestSpecBuilder builder = new RequestSpecBuilder();
		builder.setBaseUri("http://localhost:3000");  //http://localhost:3000/posts ?
		builder.setContentType(ContentType.JSON);
		
		RequestSpecification requestSpec;
		requestSpec = builder.build();
		request = RestAssured.given().spec(requestSpec);
		
//Act and Assertion
//assertThat("Author is inccorrect", request.get("/2").getBody().jsonPath().get("author"),)
	}
	
	public static void GetOpsWithPathParameter(String url, Map<String, String> pathParams) throws URISyntaxException  {
		request.pathParams(pathParams);
		request.get(new URI(url));
	}
	
	public static void GetOp(String url) throws URISyntaxException  {
		request.get(new URI(url));
	}
	public static ResponseOptions<Response> GetOps(String url){
		 try {
			return request.get(new URI(url));
		} catch (URISyntaxException e) {
			e.printStackTrace();
		}
		 return null;
	}	

	public static ResponseOptions<Response> GetOpsWithToken(String url, String token){
		 try {
			request.header(new Header("Authorization", "Bearer "+token));
			return request.get(new URI(url));
		} catch (URISyntaxException e) {
			e.printStackTrace();
		}
		 return null;
	}	

	
	public static ResponseOptions<Response> GetOpsQueryParams(String url, String queryParams){
		 try {
			request.queryParam(queryParams);
			return request.get(new URI(url));
		} catch (URISyntaxException e) {
			e.printStackTrace();
		}
		 return null;
	}
	
	public static ResponseOptions<Response> PostOpsWithBodyPathParams(String url, Map<String, String> pathParams, Map<String, String> body){

		RestAssuredExtension rea = new RestAssuredExtension();
		rea.request.pathParams(pathParams);
		//request.pathParams(pathParams);
		rea.request.body(body);
//		request.body(body);
		
			return request.post(url);  //(new URI(url))
	}
	
	public static ResponseOptions<Response> PostOpsWithBody(String url,  Map<String, String> body){
		
		RestAssuredExtension rea = new RestAssuredExtension();
		rea.request.body(body);
		return rea.request.post(url);
	}
	
	public static ResponseOptions<Response> DeleteOpsWithPathParams(String url,  Map<String, String> pathParams){
		
		RestAssuredExtension rea = new RestAssuredExtension();
		rea.request.pathParams(pathParams);
		return rea.request.delete(url);
	}	

	public static ResponseOptions<Response> GetOpsWithPathParams(String url,  Map<String, String> pathParams){
		
		RestAssuredExtension rea = new RestAssuredExtension();
		rea.request.pathParams(pathParams);
		return rea.request.get(url);
	}

	public static ResponseOptions<Response> PUTOpsWithBodyAndPathParams(String url, Map<String, String> body, Map<String, String> pathParams) {
		RestAssuredExtension rea = new RestAssuredExtension();
		rea.request.pathParams(pathParams);
		rea.request.body(body);
		
		return rea.request.put(url);
	}	

//with query parameter "?id=" instead of path param e.g. "/1"
	public static ResponseOptions<Response> GetOpsWithQueryParamsWithToken(String url,  Map<String, String> queryParams, String token){
		
		RestAssuredExtension rea = new RestAssuredExtension();
//		rea.request.header(new Header("Authorization", "Bearer "+token));

		rea.request.queryParams(queryParams);
		return rea.request.get(url);
	}
	
}
