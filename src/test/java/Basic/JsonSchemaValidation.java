package Basic;

import java.io.File;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.module.jsv.JsonSchemaValidator;

public class JsonSchemaValidation {

	public static void main(String[] args) {


		String jsonStringPayload = "{\"username\" : \"admin\",\"password\" : \"password123\"}";

		MatcherAssert.assertThat(jsonStringPayload, JsonSchemaValidator.matchesJsonSchemaInClasspath("RequestJsonSchema.json"));

		

		// GIVEN
		String res = RestAssured
			.given()
				.baseUri("https://restful-booker.herokuapp.com/auth")
				.contentType(ContentType.JSON)
				.body(jsonStringPayload)
		// WHEN
			.when()
				.post()
		// THEN
			.then()
				.assertThat()
				.statusCode(200)
				.body("token", Matchers.notNullValue())
				.body(JsonSchemaValidator.matchesJsonSchema(new File("/Users/pradeep/Documents/Learning_Workspace/RestAPI_Basics_RS/src/test/java/files/ResponseJsonSchema.json")))
				.extract().response().asString();

		System.out.println(res);

	}

}
