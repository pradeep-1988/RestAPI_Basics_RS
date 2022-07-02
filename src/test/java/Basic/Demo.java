package Basic;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.testng.Assert;

import files.payload;
import files.reusableMethods;

public class Demo {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		//Validate is AddPlace API is working as expected.
		//Given: All input details.
		//When: Submit the API with http method & resource
		//Then: validate the response.
		
		RestAssured.baseURI = "https://rahulshettyacademy.com";
		String response = given().queryParam("key", "qaclick123").header("Content-Type","application/json")
		
		//.body(payload.AddPlace())
			/*	 * How to send static json files (Payload) directly into Post method of Rest Assured.
				 * - For this we need to change the content of file to String and this can be done by converting file 
				 * - content to Byte and then Byte data to String. for example:
			*/
		.body(new String(Files.readAllBytes(Paths.get("C:\\Users\\kumar.pradeep\\Documents\\Learning_Workspace\\RestAPI_Framework_RS\\src\\test\\java\\files\\Addplace.json"))))
		.when().post("/maps/api/place/add/json")
		.then()
			.assertThat()
				.statusCode(200)
				.body("scope", equalTo("APP"))
				.header("Server", "Apache/2.4.18 (Ubuntu)")
			.extract().response().asString();    // Extract the complete response in String format.
		
		System.out.println(response);
		//System.out.println(response);
		
		// Update place with a new address-> Get place to validate if new address is correctly updated.
		
		//JsonPath js = new JsonPath(response);
		JsonPath js = reusableMethods.rawToJson(response);
		String placeId=js.getString("place_id");
		
		System.out.println(placeId);
		
		//GetPlace
				String GetPlaceResponse = given().queryParam("place_id", placeId).queryParam("key", "qaclick123")
				.when().get("maps/api/place/get/json")
				.then()
					.assertThat()
						.statusCode(200)
					.extract().response().asString();
				
				//JsonPath jsn = new JsonPath(GetPlaceResponse);
				JsonPath jsn = reusableMethods.rawToJson(GetPlaceResponse);
				String oldAddress = jsn.getString("address");
				System.out.println("Old address is "+ oldAddress);
		
		//update place
		String newAddress = "70 Summer walk, USA";
		given().queryParam("key", "qaclick123").header("Content-Type","application/json")
			.body("{\r\n"
					+ "\"place_id\":\""+placeId+"\",\r\n"
					+ "\"address\":\""+newAddress+"\",\r\n"
					+ "\"key\":\"qaclick123\"\r\n"
					+ "}")
			.when().put("maps/api/place/update/json")
			.then()
				.assertThat()
					.statusCode(200)
					.body("msg", equalTo("Address successfully updated"));
		
		//GetPlace
		String GetPlaceResponse2 = given().queryParam("place_id", placeId).queryParam("key", "qaclick123")
		.when().get("maps/api/place/get/json")
		.then()
			.assertThat()
				.statusCode(200)
			.extract().response().asString();
		
		//JsonPath jsn2 = new JsonPath(GetPlaceResponse2);
		JsonPath jsn2 = reusableMethods.rawToJson(GetPlaceResponse2);
		String getAddress = jsn2.getString("address");
		System.out.println("Newly updated address is "+ getAddress);
		
		Assert.assertEquals(getAddress, newAddress);
		Assert.assertEquals(getAddress, newAddress);
		Assert.assertEquals(getAddress, newAddress);
		Assert.assertEquals(getAddress, newAddress);
		
		

	}

}
