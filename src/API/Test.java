package API;

import static io.restassured.RestAssured.given;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

import static org.hamcrest.Matchers.*;

import files.payload;

public class Test {

	public static void main(String[] args) {
		
		//Validate if Add Place API is working as expected .
				// given - all input details 
				// when - Submit the API - resource, h t t p method
				//Then - validate the response
		
		RestAssured.baseURI = "https://rahulshettyacademy.com";
		String response=given().log().all().queryParam("key", "qaclick123").header("Content-Type","application/json")
		.body(payload.AddPlace()).when().post("maps/api/place/add/json")
		.then().assertThat().statusCode(200).body("scope",equalTo("APP"))
		.headers("server","Apache/2.4.52 (Ubuntu)").extract().response().asString();
		
		
		System.out.println(response);
		JsonPath js = new JsonPath(response); // for parsing Json
		String placeID = js.getString("place_id");
		System.out.println(placeID);
		
		
		//Add place-> Update Place with New Address -> Get Place to validate if  New address is present in response.

		//Update Place
		
		given().log().all().queryParam("key", "qaclick123").header("Content-Type","application/json")
		.body("{\r\n" + 
				"\"place_id\":\""+placeID+"\",\r\n" + 
				"\"address\":\"70 Summer walk , USA\",\r\n" + 
				"\"key\":\"qaclick123\"\r\n" + 
				"}").
		when().put("maps/api/place/update/json")
		.then().assertThat().log().all().statusCode(200).body("msg", equalTo("Address successfully updated"));
		
		
	}

}
