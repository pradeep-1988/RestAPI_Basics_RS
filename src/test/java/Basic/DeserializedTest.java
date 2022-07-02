package Basic;

import static io.restassured.RestAssured.*;

import POJO.Employees;
import io.restassured.RestAssured;
import io.restassured.parsing.Parser;
import io.restassured.path.json.JsonPath;

public class DeserializedTest {

	public static void main(String[] args) {
		
		RestAssured.baseURI = "http://dummy.restapiexample.com/api/v1/";
		
		String response = given()
		.when().get("employees")
		.then().extract().response().asString();
		
		System.out.println(response);
		
		// Get the 10th employee name with JsonPath class parser.
		JsonPath js = new JsonPath(response);
		System.out.println("With the help of JsonPath Class: EmployeeName is "+js.getString("data[9].employee_name"));
		System.out.println("With the help of JsonPath Class: Status is "+js.getString("status"));
		System.out.println("With the help of JsonPath Class: Message is "+js.getString("message"));
		
		System.out.println("#####################################################################");
		//Get the 10th employee name with the help of POJO
		Employees response2 = given().expect().defaultParser(Parser.JSON)
				.when().get("employees")
				.then().extract().response().as(Employees.class);
		System.out.println("With the help of POJO Class: EmployeeName is "+response2.getData().get(9).getEmployee_name());
		System.out.println("With the help of JsonPath Class: Status is "+response2.getStatus());
		System.out.println("With the help of JsonPath Class: Message is "+response2.getMessage());
		
		

	}

}
