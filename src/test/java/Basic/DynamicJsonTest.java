package Basic;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import files.payload;
import files.reusableMethods;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;



public class DynamicJsonTest {
	
	
	/*
	 * Dynamically build json payload with external data inputs.
	 * Parameterize the API Tests with multiple data sets.
	 */
	
	@Test(dataProvider="BooksData")
	public void addBook(String isbn, String aisle) {
		RestAssured.baseURI = "http://216.10.245.166";
		String res = given().header("Content-Type","application/json").body(payload.AddBook(isbn,aisle))
		.when().post("Library/Addbook.php")
		.then().assertThat().statusCode(200)
		.extract().response().asString();
		
		System.out.println(res);
		
		JsonPath js = reusableMethods.rawToJson(res);
		String bookId = js.get("ID");
		System.out.println("Book ID is "+ bookId);
		
	}
	
	@Test(dataProvider="BooksData", dependsOnMethods = { "addBook" })
	public void deleteBook(String isbn, String aisle) {
		RestAssured.baseURI = "http://216.10.245.166";
		String response = given().queryParam("ID", isbn+aisle)
		.when().post("/Library/DeleteBook.php")
		.then().assertThat().statusCode(200)
		.extract().response().asString();
		System.out.println(response);
		
	}
	
	@DataProvider(name="BooksData")
	public Object[][] getData() {
		//Array: Collection of elements.
		//Multidimensional Array: Collection of arrays
		return new Object[][] {{"hdhg65","765r"},{"gfgf4","656tfgh"},{"gfty5","ut6tv"},{"hgvyt5","hf54df"},{"gvtyr56","hgf4"}};
		
	}
}
