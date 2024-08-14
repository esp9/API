package files;

import org.testng.annotations.Test;

import io.restassured.path.json.JsonPath;

public class SumValidation {

	@Test
	public void sumofCourses()
	{
		JsonPath js = new JsonPath(payload.CoursePrice());
		int count =	js.getInt("courses.size()");
		for(int i = 0; i<count; i++)
		{
			int price = js.getInt("courses["+i+"].price");
			int cpoies = js.getInt("courses["+i+"].price");
			int amount = price+cpoies;
			System.out.println(amount);
			
			
	 }
		
   }
}
