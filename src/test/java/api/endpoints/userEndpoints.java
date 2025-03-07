package api.endpoints;

//crud method implementations(create,get,update,delete request)
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import api.payload.User;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class userEndpoints {
	
	
	public static Response createUser(User payload)
	{
		
		Response resp=given()
			.contentType(ContentType.JSON)
			.accept(ContentType.JSON)
			.body(payload)
		
		.when()
		.post(Routes.posturl);
		
		return resp;
		
	}
	public static Response readUser(String username)
	{
		
		Response resp=given()
			
			.pathParam("username", username)
			
		
		.when()
		.get(Routes.geturl);
		
		return resp;
		
	}
	
	public static Response updateUser(String username,User payload)
	{
		
		Response resp=given()
			.contentType(ContentType.JSON)
			.accept(ContentType.JSON)
			.pathParam("username", username)
			.body(payload)
			
		
		.when()
		.put(Routes.updateurl);
		
		return resp;
		
	}
	public static Response deleteUser(String username)
	{
		
		Response resp=given()
			
			.pathParam("username", username)
			
		
		.when()
		.get(Routes.deleteurl);
		
		return resp;
		
	}
	
	

}
