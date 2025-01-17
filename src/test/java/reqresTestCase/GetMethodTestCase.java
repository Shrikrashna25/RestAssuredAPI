package reqresTestCase;
//implicitly we need to import package of RestAssure
import static io.restassured.RestAssured.*;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;
public class GetMethodTestCase {
	// methods -- each method treated as single test case
		// to run these single test case @Test annotastion -- TestNG
	static String baseURL = "https://reqres.in/api/users/";
	static String validpageNumber = "2";
	static String inValidpageNumber = "234567890";
	static String validUserID="2";
	static String invalidUserID="23224432422";
	
	@Test(priority = 0)
	public void toVerifyListUsersWithValidPage(){
		// given() method is used to start building the api req..
				// to create and pass query parameter in restassured having the param method
				// and to cretae and pass the path param in restassured having the path method
				// https://reqres.in/api/users?page=1
				// https://reqres.in/api/users/2
	given()	
	.param("page","2")
		.when()
		.get("https://reqres.in/api/users")
		//.get("https://reqres.in/api/users?page=2")
		.then()
		.log()
		.all();
	
	}
	// Query parameter
	@Test(priority = 1)
   public void toVerifyListUsersWithNotValidPage(){
		given()	
		.param("page","456484678765")
			.when()
			.get("https://reqres.in/api/users")
			//.get("https://reqres.in/api/users?page=2") Query parameter
			.then()
			.log()
			.all();
	}
	@Test(priority = 2)
	// path parameter 
	public void toVerifySingleUserWithValidID(){
		given().pathParam("UserID", " 2").when().get(" https://reqres.in/api/users/{UserID}").then().log().all();
		
		
	}
	@Test(priority= 3)
	public void toVerifyCreateNewUserWithValidDetails() {
		given()
		.body("{\r\n"
				+ "    \"name\": \"Testing shastra\",\r\n"
				+ "    \"job\": \"Institute\"\r\n"
				+ "}")
		.contentType(ContentType.JSON)
		.when()
		.post("https://reqres.in/api/users")
		.then()
		.log()
		.all();
	}
}
