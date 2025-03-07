package api.endpoints;


//maintain only the URLs

	//Swagger URL-https://petstore.swagger.io/
	//Create user(post)-https://petstore.swagger.io/v2/user
	//Get User(get)-https://petstore.swagger.io/v2/user/{username}
	//Update user(put)-https://petstore.swagger.io/v2/user/{username}
	//Delete User(delete)- https://petstore.swagger.io/v2/user/{username}

public class Routes {
	
	
	
	public static String baseurl="https://petstore.swagger.io/v2";
	
	//user module
	public static String posturl=baseurl+"/user";
	public static String geturl=baseurl+"/user/{username}";
	public static String updateurl=baseurl+"/user/{username}";
	public static String deleteurl=baseurl+"/user/{username}";
	
	//store module
	
	//pet module
	
			
	
	
		

}
