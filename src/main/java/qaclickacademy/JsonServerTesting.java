package qaclickacademy;

import org.testng.annotations.Test;
import com.jayway.restassured.http.ContentType;
import com.jayway.restassured.response.Response;
import static com.jayway.restassured.RestAssured.*;
public class JsonServerTesting {

	//GET    /posts
	
	@Test
	public void test_01() {
		
		Response rest = given().
				body(" {\"id\": \2\","
						+ " \"title\":\"dummyTitle\"," 
						+ " \"author\":\"saurabh\"  } ").
				when().
				contentType(ContentType.JSON).
				post("http://localhost:3000/posts");
		
		System.out.println(rest.asString());
				
	}
	
}
