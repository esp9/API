package files;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

public class DynamicJson {
	
	

		@Test
		public  void addbook() 
		{
//			RestAssured.baseURI="http://216.10.245.166";
//			String response = given().log().all().header("Content-Type","application/json").
//			body(payload.Addbook()).
//			when()
//			.post("/Library/Addbook.php")
//			.then().assertThat().statusCode(200)
//			.extract().response().asString();
//			JsonPath js = ReUseableMethods.rowToJson(response);
//			String id = js.get("ID");
//			System.out.println(id);
			
			RestAssured.baseURI="http://216.10.245.166";
			String response = given().log().all().header("Content-Type","application/json").
			body(payload.Addbook("adfs","9491")).
			when()
			.post("/Library/Addbook.php")
			.then().assertThat().statusCode(200)
			.extract().response().asString();
			JsonPath js = ReUseableMethods.rowToJson(response);
			String id = js.get("ID");
			System.out.println(id);
			
		
	}


}
