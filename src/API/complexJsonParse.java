package API;

import files.payload;
import io.restassured.path.json.JsonPath;

public class complexJsonParse {

	public static void main(String[] args) {
		

		JsonPath js = new JsonPath(payload.CoursePrice());
		//1. Print No of courses returned by API
		
	int count =	js.getInt("courses.size()");
	System.out.println(count);
	
	//2.Print Purchase Amount
	
	int totalAomunt =js.getInt("dashboard.purchaseAmount");
	System.out.println(totalAomunt);
	
	//3. Print Title of the first course
	
	String titleFristCourse=js.get("courses[2].title");
	System.out.println(titleFristCourse);
	
	String titleFristCourse1=js.get("courses[0].title");
	System.out.println(titleFristCourse1);
	
	//4. Print All course titles and their respective Prices
	
	for(int i =0; i<count; i++) 
	{
		String coursesTitles=js.get("courses["+i+"].title");
		
		
		System.out.println(js.get("courses.["+i+"].price").toString());
		
		System.out.println(coursesTitles);
		//5.Print no of copies sold by RPA Course
				
	}
	System.out.println("Print no of copies sold by RPA Course");
	
	for(int i =0; i<count; i++) 
	{
		String coursesTitles=js.get("courses["+i+"].title");
		
		if(coursesTitles.equalsIgnoreCase("RPA"))
		{
			int cpoies = js.get("courses["+i+"].copies");
			System.out.println(cpoies);
			break;
		}

	  }
		
   }
	
}
