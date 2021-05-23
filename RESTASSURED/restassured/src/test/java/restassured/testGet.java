package restassured;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import org.hamcrest.core.StringContains;
import org.junit.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class testGet {
	
	Response response = RestAssured.get("https://api.trello.com/1/actions/592f11060f95a3d3d46a987a/list");
	
	
	public void statusCode() {
		
		int statusCode = response.getStatusCode();
		System.out.println(statusCode);
		assertEquals(200, statusCode);
		
	}
	
	
	public void bodyList() {
		
		String bodyResponse = response.asString();
		System.out.println("O valor do get" + bodyResponse);
		
		String name = "Professional";
		
		assertThat(bodyResponse, StringContains.containsString(name));
		
		
	}
	
	@Test
	public void time() {
		
		long time = response.time();
		
		boolean resultado = false;
		
		if(time <= 3000) {
			
			resultado = true;
		}
		
		assertTrue(resultado);
		
	}

}
