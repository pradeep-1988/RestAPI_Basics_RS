package Glow6;

import static io.restassured.RestAssured.given;

import files.payload;
import io.restassured.RestAssured;
import io.restassured.response.Response;

public class createSR2 {

	public static void main(String[] args) {
		RestAssured.baseURI = "https://backendportal-in-dev.corp.globant.com/BackendPortal-ui14/";
		Response res = given().queryParam("username", "hazel.fernandes")
				.when().get("login/fakeLogin")
				.then().assertThat().statusCode(200)
				.extract().response();
		
		System.out.println(res.getSessionId());
		System.out.println(res.asString());

		String res2 = given().sessionId(res.getSessionId()).header("Content-Type","application/json").body(payload.SRPayload())
				.when().post("proxy/glow/positionservice/positions")
				.then()
				.extract().response().asString();

		System.out.println(res2);


	}

}
