package qaclickacademy;

import org.testng.annotations.Test;

import com.jayway.restassured.http.ContentType;
import com.jayway.restassured.internal.assertion.Assertion;
import com.jayway.restassured.response.Response;

import junit.framework.Assert;

import static com.jayway.restassured.RestAssured.*;

public class WeatherGetRequest {

	//simple get request
	
	//@Test
	public void Test_01() {
		
		Response resp = when().		
		get("https://samples.openweathermap.org/data/2.5/weather?q=London,uk&appid=3cd01cd42a13367c9eff7cf6c013e949");
		
		System.out.println(resp.getStatusCode());
		Assert.assertEquals(resp.getStatusCode(),200);
	}
	
	//how to use parameter with rest assured 
	//@Test
	public void Test_02() {
		Response resp = given().
				param("q","London").
				param("appid","3cd01cd42a13367c9eff7cf6c013e949").
				when().
				get("https://samples.openweathermap.org/data/2.5/weather");
		
		System.out.println(resp.getStatusCode());
		Assert.assertEquals(resp.getStatusCode(),200);
		
		if (resp.getStatusCode()==200) 
		{
			System.out.println("API is working fine ");
		}
		else
		{
			System.out.println(" API is not working fine");
		}
	}	
	
	//@Test
	public void Test_03() {
		        given().
				param("q","London").
				param("appid","3cd01cd42a13367c9eff7cf6c013e949").
				when().
				get("https://samples.openweathermap.org/data/2.5/weather").
		        then().
		        assertThat().statusCode(200);
	}
	
	//What all are there in response
	//@Test
	public void Test_04() {
        Response rest= given().
		param("q","London").
		param("appid","3cd01cd42a13367c9eff7cf6c013e949").
		when().
		get("https://api.openweathermap.org/data/2.5/weather");
        System.out.println(rest.asString());
             
}
	//@Test
	public void Test_05() {
		Response rest = given().
				param("id","2172797").
				param("appid","3cd01cd42a13367c9eff7cf6c013e949").
                when().
                get("https://api.openweathermap.org/data/2.5/weather");
		
		System.out.println(rest.asString());
	}
	
	//@Test
	public void Test_06() {
		String weatherReport = given().
				param("id","2172797").
				param("appid","3cd01cd42a13367c9eff7cf6c013e949").
                when().
                get("https://api.openweathermap.org/data/2.5/weather").
                then().contentType(ContentType.JSON).
                extract().
                path("weather[0].description");          
		
		        System.out.println("weather report" +weatherReport);		
	}	
	
	
	// API value is given to another API
	@Test
	public void Test_07() {
	  Response resp = given().
				param("id","2172797").
				param("appid","3cd01cd42a13367c9eff7cf6c013e949").
                when().
                get("https://api.openweathermap.org/data/2.5/weather");
	  
	  String reportbyId = resp.                
                then().contentType(ContentType.JSON).
                extract().
                path("weather[0].description");          
		
		        System.out.println("weather report" +reportbyId);		
	}
	}
	
