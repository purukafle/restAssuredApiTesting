package api.endpoint;

import static io.restassured.RestAssured.given;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

//user endpoints
//created for perform create, read, update, delete request to the user API
public class UserEndPoint {
	public static Response createUser(User payload){
		Response response=given()
			.contentType(ContentType.JSON)
			.accept(ContentType.JSON)
			.body(payload)
		.when()
			.post(Routes.post_url);
		
		return response;
		
	}
	public static Response readUser(String userName){
		Response response=given()
				.pathParam("username", userName)
			
		.when()
			.post(Routes.post_url);
		
		return response;
		
	}
	public static Response updateUser(String userName, User payload){
		Response response=given()
			.contentType(ContentType.JSON)
			.accept(ContentType.JSON)
			.pathParam("username", userName)
			.body(payload)
		.when()
			.post(Routes.post_url);
		
		return response;
		
	}
	
	public static Response createUser(User payload){
		Response response=given()
			.contentType(ContentType.JSON)
			.accept(ContentType.JSON)
			.body(payload)
		.when()
			.post(Routes.post_url);
		
		return response;
		
	}

}
