package api.test;

import org.testng.Assert;
import org.testng.annotations.Test;

import api.endpoints.userEndpoints;
import api.payload.User;
import api.utilities.DataProviders;
import io.restassured.response.Response;

public class DDTests {
	
	@Test(priority=1,dataProvider="Data",dataProviderClass=DataProviders.class)
	public void testPostUser(String userId,String username,String fname,String lname,String email,String pwd,String phone)
	{
		User userpayload=new User();
		userpayload.setId(Integer.parseInt(userId));
		userpayload.setUsername(username);
		userpayload.setFirstName(fname);
		userpayload.setLastName(lname);
		userpayload.setEmail(email);
		userpayload.setPassword(pwd);
		userpayload.setPhone(phone);
		
		Response resp=userEndpoints.createUser(userpayload);
		Assert.assertEquals(resp.getStatusCode(), 200);
		
	}
	
	@Test(priority=2,dataProvider="UserNames",dataProviderClass=DataProviders.class)
	public void testDeleteUser(String username)
	{
		Response resp=userEndpoints.deleteUser(username);
		//Assert.assertEquals(resp.getStatusCode(), 200);
	}

}
