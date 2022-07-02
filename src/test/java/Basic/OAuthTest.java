package Basic;

import static io.restassured.RestAssured.*;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import POJO.WebAutomation;
import POJO.getCourse;
import io.restassured.parsing.Parser;
import io.restassured.path.json.JsonPath;

public class OAuthTest {

	public static void main(String[] args) throws InterruptedException {
		
		//Get Authorization code:
		
		//Need to build the url from the API contract received from Application developer.
	/*
		String url = "https://accounts.google.com/o/oauth2/v2/auth?scope=https://www.googleapis.com/auth/userinfo.email&auth_url=https://accounts.google.com/o/oauth2/v2/auth&client_id=692183103107-p0m7ent2hk7suguv4vq22hjcfhcr43pj.apps.googleusercontent.com&response_type=code&redirect_uri=https://rahulshettyacademy.com/getCourse.php&state=verifydss";
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\kumar.pradeep\\Documents\\Learning_Workspace\\ChromeDriver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get(url);
		Thread.sleep(2000);
		driver.findElement(By.cssSelector("input[type='email']")).sendKeys("rohit.jakhar88");
		driver.findElement(By.cssSelector("input[type='email']")).sendKeys(Keys.ENTER);
		Thread.sleep(3000);
		driver.findElement(By.cssSelector("input[type='email']")).sendKeys("harbeerlali");
		driver.findElement(By.cssSelector("input[type='email']")).sendKeys(Keys.ENTER);
		Thread.sleep(4000);
		String cUrl = driver.getCurrentUrl();
		*/
		String cUrl = "https://rahulshettyacademy.com/getCourse.php?state=verifydss&code=4%2F0AX4XfWgoe0TQkQIykiMwUaSZdUROi2RyHiB2RrRdrP-yiotCaVVhgx_yqem6-vZq1WmlqQ&scope=email+openid+https%3A%2F%2Fwww.googleapis.com%2Fauth%2Fuserinfo.email&authuser=0&prompt=none";
		String partialCode = cUrl.split("code=")[1];
		String expectedCode = partialCode.split("&scope")[0];
		System.out.println(expectedCode);
		
		//Get Access Token

		String accessTokenResponse = 
				given().urlEncodingEnabled(false)
					.queryParams("code",expectedCode)
					.queryParams("client_id","692183103107-p0m7ent2hk7suguv4vq22hjcfhcr43pj.apps.googleusercontent.com")
					.queryParams("client_secret","erZOWM9g3UtwNRj340YYaK_W")
					.queryParams("redirect_uri","https://rahulshettyacademy.com/getCourse.php")
					.queryParams("grant_type","authorization_code")
				.when().log().all()
					.post("https://www.googleapis.com/oauth2/v4/token").asString();

		JsonPath js1 = new JsonPath(accessTokenResponse);
		String AccessToken = js1.getString("access_token");


		String response = 
				given()
					.queryParam("access_token", AccessToken)
				.when().log().all()
					.get("https://rahulshettyacademy.com/getCourse.php").asString();

		//System.out.println(response);
		
		//Serialization: it is the process to convert Java object to request body payload (json/xml) based on POJO classes.
		//Deserialization: It is the process to convert response body payload (json/xml) to Java object based on POJO classes.
		//POJO clasess are created based on request/response payload.
		//External libraries would be required for this: Jackson/Jackson2,Gson for JSON and JAXB for xml.
		
		getCourse response2 = 
				given()
					.queryParam("access_token", AccessToken).expect().defaultParser(Parser.JSON)
				.when()
					.get("https://rahulshettyacademy.com/getCourse.php").as(getCourse.class);
		
		System.out.println(response2.getLinkedIn());
		System.out.println(response2.getInstructor());
		
		System.out.println(response2.getCourses().getApi().get(1).getCourseTitle());
		System.out.println(response2.getCourses().getApi().get(1).getPrice());
		
		List<WebAutomation> webCourses = response2.getCourses().getWebAutomation();
		for(int i=0;i<webCourses.size();i++) {
			if(webCourses.get(i).getCourseTitle().equalsIgnoreCase("Selenium Webdriver Java")) {
				System.out.println("Price of Selenium Webdriver Java web Automation course is :"+webCourses.get(i).getPrice());
				
			}
					
		}
	}

}
