package com.reqSpecAndBuilder;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
// This class request Specification and builder Using RestAssured FramWork
public class CreateUsersUsingReqSpecAndBuilder {
	
	public RequestSpecification createUserWithValidData() {
		   RequestSpecBuilder builder = new RequestSpecBuilder();
		   builder.setBody("{\r\n"
					+ "    \"name\": \"Testing shastra\",\r\n"
					+ "    \"job\": \"Institute\"\r\n"
					+ "}");
		 //  builder.addHeader("Authorization","Bearer 883cbb49eb5ac8b8671f873a69a6a5698638aa6ca0e2b9a8db396700a4cae642");
		   builder.setContentType(ContentType.JSON);
		   builder.setBaseUri("https://reqres.in/api/users");
		   RequestSpecification reqSpecification = builder.build();
		   return reqSpecification; 
	}
  
	public RequestSpecification getUserWithreqSpec() {
		 RequestSpecBuilder builder = new RequestSpecBuilder();
		 builder.setBaseUri("https://gorest.co.in/public/v2/users/7001810");
		 RequestSpecification reqSpecification = builder.build();
		   return reqSpecification; 
		
	
		
	}
     
}
