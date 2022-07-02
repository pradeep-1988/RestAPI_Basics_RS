package Glow6;

import static io.restassured.RestAssured.given;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import files.payload;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class createSR {
	String sessionID;
	int positionID;
	
	@BeforeTest
	public void fakeLogin() {
		RestAssured.baseURI = "https://backendportal-in-dev.corp.globant.com/BackendPortal-ui14/";
		Response res = given().queryParam("username", "hazel.fernandes")
				.when().get("login/fakeLogin")
				.then().assertThat().statusCode(200)
				.extract().response();
				System.out.println(res.asString());
				sessionID = res.getSessionId();
	}
	
	@Test
	public void createStaffRequest() {
		RestAssured.baseURI = "https://backendportal-in-dev.corp.globant.com/BackendPortal-ui14/";
		Response res = given().sessionId(sessionID).header("Content-Type","application/json").body(payload.SRPayload())
				.when().post("proxy/glow/positionservice/positions")
				.then()
				.extract().response();	
				System.out.println(res.asString());
		JsonPath js = new JsonPath(res.asString());
		//System.out.println(js.getString("message"));
		positionID = js.getInt("details.positionDTOs[0].positionId");
		//System.out.println(positionID);
	}
	
	@Test(dependsOnMethods = { "createStaffRequest" })
	public void cancelStaffRequest() {
		RestAssured.baseURI = "https://backendportal-in-dev.corp.globant.com/BackendPortal-ui14/";
		Response res = given().sessionId(sessionID).header("Content-Type","application/json")
							  .body("{\"positionId\":\""+positionID+"\",\"cancelReasonId\":8,\"comments\":\"Test\"}")
				.when().put("proxy/glow/staffingorchestraservice/positions/cancels")
				.then()
				.extract().response();	
				System.out.println(res.asString());
		
	}

}
