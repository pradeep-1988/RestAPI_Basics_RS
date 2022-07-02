package Basic;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import POJO.AddPlace;
import POJO.Location;
import io.restassured.RestAssured;

public class serializedTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	AddPlace ap = new AddPlace();
	ap.setAccuracy(50);
	ap.setName("Frontline house");
	ap.setPhone_number("(+91) 983 893 3937");
	ap.setAddress("29, side layout, cohen 09");
	ap.setWebsite("http://google.com");
	ap.setLanguage("French-IN");
	
	List<String> mylist = new ArrayList<String>();
	mylist.add("shoe park");
	mylist.add("shop");
	ap.setTypes(mylist);
	
	Location lc = new Location();
	lc.setLat(-38.383494);
	lc.setLng(33.427362);
	ap.setLocation(lc);
	
	
		
		RestAssured.baseURI = "https://rahulshettyacademy.com";
		String response = given().queryParam("key", "qaclick123").header("Content-Type","application/json")
				.body(ap)
				.when().post("/maps/api/place/add/json")
				.then()
					.assertThat()
						.statusCode(200)
						.body("scope", equalTo("APP"))
						.header("Server", "Apache/2.4.18 (Ubuntu)")
					.extract().response().asString();    // Extract the complete response in String format.
				
				System.out.println(response);
				//System.out.println(response);
	}

}
