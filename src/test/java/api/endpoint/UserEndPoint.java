package api.endpoint;

import static io.restassured.RestAssured.given;

import api.payload.User;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

//user endpoints
//created for perform create, read, update, delete request to the user API
public class UserEndPoint {
	public static Response createUser(User payload) {
		Response response = given().contentType(ContentType.JSON).accept(ContentType.JSON).body(payload).when()
				.post(Routes.post_url);

		return response;

	}

	public static Response readUser(String userName) {
		Response response = given().pathParam("username", userName)

				.when().get(Routes.get_url);

		return response;

	}

	public static Response updateUser(String userName, int i) {
		Response response = given().contentType(ContentType.JSON).accept(ContentType.JSON)
				.pathParam("username", userName).body(i).when().put(Routes.update_url);

		return response;

	}

	public static Response deleteUser(String userName) {
		Response response = given().pathParam("username", userName)

				.when().delete(Routes.post_url);

		return response;

	}

}
