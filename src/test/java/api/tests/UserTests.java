package api.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import io.restassured.response.Response;
import com.github.javafaker.Faker;

import api.endpoint.UserEndPoint;
import api.payload.User;

public class UserTests {
	User userPayload;
	Faker faker;
	@BeforeClass
	public void setupData() {
		faker=new Faker();
		userPayload=new User();
		
		userPayload.setId(faker.idNumber().hashCode());
		userPayload.setFirstName(faker.name().username());
		userPayload.setFirstName(faker.name().firstName());
		userPayload.setLastName(faker.name().lastName());
		userPayload.setEmail(faker.internet().safeEmailAddress());
		userPayload.setPassword(faker.internet().password(5,10));
		userPayload.setPhone(faker.phoneNumber().cellPhone());
				
	}
	@Test(priority=1)
	public void testPostUser() {
		
		Response response= UserEndPoint.createUser(userPayload);
		response.then().log().all();
		Assert.assertEquals(response.statusCode(),200);
		
	}
	@Test
	public void testGetUserByName() {
		Response response=UserEndPoint.readUser(this.userPayload.getUsername());
		response.then().log().all();
		Assert.assertEquals(response.getStatusCode(),200);
	}
	@Test
	public void testUpdateUserByName() {
		//update data using payload
		userPayload.setFirstName(faker.name().firstName());
		userPayload.setLastName(faker.name().lastName());
		userPayload.setEmail(faker.internet().safeEmailAddress());
		
		Response response=UserEndPoint.updateUser(this.userPayload.getStatusCode(),200);
		response.then().log().body();
		Assert.assertEquals(response.getStatusCode(),200);
		//checking data after update
		Response responseAfterupdate=UserEndPoint.readUser(this.userPayload.getUsername());
		response.then().log().all();
		Assert.assertEquals(responseAfterupdate.getStatusCode(),200);
		
		
	}
	@Test
	public void testDeleteUserByName() {
	Response response=UserEndPoint.deleteUser(this.userPayload.getUsername());
	Assert.assertEquals(response.getStatusCode(), 200);
		
		
	}
	
}
