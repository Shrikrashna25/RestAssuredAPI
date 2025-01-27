package reqresTestCase;

import static io.restassured.RestAssured.given;
import com.reqSpecAndBuilder.CreateUsersUsingReqSpecAndBuilder;

import java.util.Scanner;

import org.testng.annotations.Test;

import com.TestData.TestDataForRequres;
import com.pogo.PogoClass;
import com.reqSpecAndBuilder.CreateUsersUsingReqSpecAndBuilder;

import io.restassured.http.ContentType;

public class CreateuserForNormalWay {
	@Test
	public void creatUserUsingPogo(){
		PogoClass pg =new PogoClass();
		pg.setName("Shrikrashna");
		pg.setJob("QA");
		given()
		.body(pg)
		.contentType(ContentType.JSON)
		.when().post("https://reqres.in/api/users/2")
		.then()
		.log()
		.all();
		
	}
	@Test
	public void createUserForGorestUsingPogoClass(){
		PogoClass pg =new PogoClass();
		pg.setName("Shrikrashna");
		pg.setEmail("Shrikrashna@gmail.com");
		pg.setGender("male");
		pg.setStatus("Active");
		given()
		.body(pg)
		.header("Authorization","Bearer 883cbb49eb5ac8b8671f873a69a6a5698638aa6ca0e2b9a8db396700a4cae642")
		.contentType(ContentType.JSON)
		.when()
		.put("https://gorest.co.in/public/v2/users")
		.then()
		.log()
		.all();
	}
	@Test
	public void createUserForGorestUsingPogoClassUserInput(){
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter name,Email,gender,status");
		String userName=sc.nextLine();
		String userEamil=sc.nextLine();
		String userGender=sc.nextLine();
		String userStatus=sc.nextLine(); 
		
		PogoClass pg =new PogoClass();
		pg.setName("Shrikrashna");
		pg.setEmail("Shrikrashna@gmail.com");
		pg.setGender("male");
		pg.setStatus("Active");
		given()
		.body(pg)
		.header("Authorization","Bearer 883cbb49eb5ac8b8671f873a69a6a5698638aa6ca0e2b9a8db396700a4cae642")
		.contentType(ContentType.JSON)
		.when()
		.put("https://gorest.co.in/public/v2/users")
		.then()
		.log()
		.all();
	}
	// Test Case Using RequestSpecification and Builder /RestAssured Frame Work
	@Test
	public void createUserWithValidData() {
		
		CreateUsersUsingReqSpecAndBuilder reqSpec = new CreateUsersUsingReqSpecAndBuilder();
		
	
		given(reqSpec.createUserWithValidData())
		//.header("Authorization","Bearer 883cbb49eb5ac8b8671f873a69a6a5698638aa6ca0e2b9a8db396700a4cae642")
		.contentType(ContentType.JSON)
		.when()
		.post()
		.then()
		.log()
		.all()
		.statusCode(201);
		
		
		
	}
	// Test Case Using RequestSpecification and Builder /RestAssured Frame Work
	
	@Test
	public void getUserUsingReqSpec() {
		CreateUsersUsingReqSpecAndBuilder reqSpec = new CreateUsersUsingReqSpecAndBuilder();
		given(reqSpec.getUserWithreqSpec())
		.when()
		.get()
		.then()
		.log()
		.all()
		.statusCode(200);
		
		
		
	}
	
	@Test
	public void updateUserDetailsUsingReqSpec() {
		CreateUsersUsingReqSpecAndBuilder reqSpec = new CreateUsersUsingReqSpecAndBuilder();
		given(reqSpec.updatetUserDetailsWithreqSpec())
		.when()
		.put()
		.then()
		.log()
		.all()
		.statusCode(200);
	}	
	// update all data using patch method
	@Test
	public void updateAllUserDetailsUsingReqSpec() {
		CreateUsersUsingReqSpecAndBuilder reqSpec = new CreateUsersUsingReqSpecAndBuilder();
		given(reqSpec.updatetUserDetailsWithreqSpec())
		.when()
		.patch()
		.then()
		.log()
		.all()
		.statusCode(200);
	}	
	
	@Test
	public void deletUserUsingReqSpec() {
		CreateUsersUsingReqSpecAndBuilder reqSpec = new CreateUsersUsingReqSpecAndBuilder();
		given(reqSpec.deletUserWithreqSpec())
		.when()
		.delete()
		.then()
		.log()
		.all()
		.statusCode(204);
	}
}
