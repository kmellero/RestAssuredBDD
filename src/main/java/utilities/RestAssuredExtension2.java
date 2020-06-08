package utilities;

import io.restassured.builder.RequestSpecBuilder;

public class RestAssuredExtension2 {

	private RequestSpecBuilder builder = new RequestSpecBuilder();
	private String method;
	private String url;

	public RestAssuredExtension2(String uri, String method, String token) {
		//Set the API url
		this.url = "http://localhost:3000" + uri;
		
	}
}
