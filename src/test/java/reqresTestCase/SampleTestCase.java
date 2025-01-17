package reqresTestCase;

import static io.restassured.RestAssured.*;
import org.testng.annotations.Test;
import io.restassured.http.ContentType;
import com.TestData.TestDataForRequres;

public class SampleTestCase {
	// methods -- each method treated as single test case
	// to run these single test case @Test annotation -- TestNG

	TestDataForRequres td = new TestDataForRequres();

	@Test(priority = 0)
	public void toVerifyListOFUsersWithValidPage() {
		// given() method is used to start building the api req..
		// to create and pass query parameter in restassured having the param method
		// and to cretae and pass the path param in restassured having the path method
		// https://reqres.in/api/users?page=1
		// https://reqres.in/api/users/2

		given().param("page", TestDataForRequres.validpageNumber).when().get(TestDataForRequres.baseURL)
				// https://reqres.in/api/users?page=1
				.then().log().all();
	}

	@Test(priority = 1)
	public void toVerifyListOFUsersWithInValidPage() {
		given().param("page", TestDataForRequres.inValidpageNumber).when().get(TestDataForRequres.baseURL)
				// https://reqres.in/api/users?page=1
				.then().log().all();

	}

	@Test(priority = 2)
	public void toVerifySingleUserWithValidUserID() {
		given().pathParam("userID", TestDataForRequres.validUserID).when().get(TestDataForRequres.baseURL + "{userID}")
				.then().log().all();
	}

	@Test(priority = 3) // Get Method
	public void toVerifySingleUserWithInValidUserID() {
		given().pathParam("userID", TestDataForRequres.invalidUserID).when()
				.get(TestDataForRequres.baseURL + "{userID}").then().log().all();

	}

	@Test(priority = 4) // Post Method
	public void toVerifyCreateNewUserWithValidDetails() {
		given().body("{\r\n" + "    \"name\": \"Testing shastra\",\r\n" + "    \"job\": \"Institute\"\r\n" + "}")
				.contentType(ContentType.JSON).when().post(TestDataForRequres.baseURL).then().log().all();

	}

	@Test(priority = 5) // Put Method
	public void toVerifyUpdateWithValidDetails() {
		given().body("{\r\n" + "    \"name\": \"morpheus\",\r\n" + "    \"job\": \"zion resident\"\r\n" + "}")
				.contentType(ContentType.JSON).when().put(TestDataForRequres.baseURL).then().log().all();
	}

	@Test(priority = 6) // Patch Method
	public void toVerifyUpdateAllValidDetails() {
		given().body("{\r\n" + "    \"name\": \"Shrikrashna\",\r\n" + "    \"job\": \"zion resident\"\r\n" + "}")
				.contentType(ContentType.JSON).when().patch(TestDataForRequres.baseURL).then().log().all();
	}
}
