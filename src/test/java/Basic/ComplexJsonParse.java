package Basic;

import org.testng.Assert;

import files.payload;
import io.restassured.path.json.JsonPath;

public class ComplexJsonParse {

	public static void main(String[] args) {

		/*	1. Print No of courses returned by API
			2.Print Purchase Amount
			3. Print Title of the first course
			4. Print All course titles and their respective Prices
			5. Print no of copies sold by RPA Course
			6. Verify if Sum of all Course prices matches with Purchase Amount
		 */

		JsonPath js = new JsonPath(payload.complexJson());
		
		//1. Print No of courses returned by API
		int count_courses = js.getInt("courses.size()");
		System.out.println("No of courses returned by API: "+ count_courses);
		System.out.println("================================================================");
		
		//2. Print Purchase Amount
		int pA = js.getInt("dashboard.purchaseAmount");
		System.out.println("Purchase Amount is: "+ pA);
		System.out.println("================================================================");
		
		//3. Print Title of the first course
		String title_first = js.getString("courses[0].title");
		System.out.println("Title of the first course is: "+ title_first);
		System.out.println("================================================================");
		
		//4. Print All course titles and their respective Prices
		for(int i=0;i<count_courses;i++) {
			String course_Title = js.getString("courses["+i+"].title");
			int course_Price = js.getInt("courses["+i+"].price");
			System.out.println("Course is "+course_Title+" and Price is "+course_Price);
		}
		System.out.println("================================================================");
		
		//5. Print no of copies sold by RPA Course
		for(int i=0;i<count_courses;i++) {
			String course_Title = js.getString("courses["+i+"].title");
			if(course_Title.equalsIgnoreCase("RPA")) {
				int cnt = js.getInt("courses["+i+"].copies");
				System.out.println("No of copies sold by RPA Course is "+cnt);
				break;
			}
		}
		System.out.println("================================================================");
		
		
		//6. Verify if Sum of all Course prices matches with Purchase Amount
		int sum = 0;
		for(int i=0;i<count_courses;i++) {
			int price = js.getInt("courses["+i+"].price");
			int copies = js.getInt("courses["+i+"].copies");
			sum = sum + price*copies;
		}
		System.out.println("Sum of all cources is "+sum);
		System.out.println("Purchase Amount is: "+ pA);
		Assert.assertEquals(sum, pA);
		System.out.println("================================================================");
	}

}
