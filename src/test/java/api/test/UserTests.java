package api.test;



import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import api.endpoints.userEndpoints;
import api.payload.User;
import io.restassured.response.Response;

public class UserTests {

	
	Faker faker;
	User user;
	public Logger logger;
	
	@BeforeClass
	public void setupData()
	{
		
		faker=new Faker();
		user=new User();
		
		user.setId(faker.idNumber().hashCode());
		user.setUsername(faker.name().username());
		user.setFirstName(faker.name().firstName());
		user.setLastName(faker.name().lastName());
		user.setEmail(faker.internet().safeEmailAddress());
		user.setPhone(faker.phoneNumber().cellPhone());
		user.setPassword(faker.internet().password(5, 10));
		
		logger=LogManager.getLogger(this.getClass());
		
	}
	
	
	@Test(priority=1)
	public void testPostUser()
	{
		logger.info("***********Creating User*********************");
		Response response=userEndpoints.createUser(user);
		response.then().log().body();
		//Assert.assertEquals(response.getStatusCode(), 200);
		logger.info("**********User Created*********************");
	}
	
	@Test(priority=2)
	public void testgetUser()
	{
		logger.info("**********Reading User*********************");
		Response response=userEndpoints.readUser(this.user.getUsername());
		response.then().log().all();
		//Assert.assertEquals(response.getStatusCode(), 200);
		logger.info("**********User info is diplayed*********************");
	}
	
	@Test(priority=3)
	public void testUpdateUser()
	
	{
		logger.info("**********Updating User*********************");
		
		user.setFirstName(faker.name().firstName());
		user.setLastName(faker.name().lastName());
		user.setEmail(faker.internet().safeEmailAddress());
		
		Response response=userEndpoints.updateUser(this.user.getUsername(), user);
		response.then().log().body();
		//Assert.assertEquals(response.getStatusCode(), 200);
		
		//checking data after update
		
		Response responseAfterUpdate=userEndpoints.readUser(this.user.getUsername());
		responseAfterUpdate.then().log().body();
		logger.info("**********User Updated*********************");
		
		
	}
	
	@Test(priority=4)
	public void testdeleteUser()
	{
		logger.info("********** deleting User*********************");
		
		Response s=userEndpoints.deleteUser(this.user.getUsername());
		//Assert.assertEquals(s.getStatusCode(), 200);
		logger.info("**********  User deleted*********************");
		
	}
	
}
