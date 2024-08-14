package files;

import io.restassured.path.json.JsonPath;

public class ReUseableMethods {

	public static JsonPath rowToJson(String response) {
		
		JsonPath js1 = new JsonPath(response);
		return js1;
		
	}
	
}
