package com.auto.testWebServices;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.RestAssured;
import static io.restassured.RestAssured.*;


public class testsimpleAPI {
	
	@Test
	public void test_get_Case01() {
		Response resp = RestAssured.get("https://reqres.in/api/users?page=2");
		System.out.println("simple get response is: " + resp.asString());
		System.out.println(resp.getStatusCode());
		System.out.println(resp.getTime());
		System.out.println(resp.getHeader("content-type"));
		
		int stat_code=resp.getStatusCode();
		Assert.assertEquals(stat_code, 201);
		
	}
	
	@Test
	public void test_get_static_Case02()
	{
		//direct validation
		baseURI = "https://reqres.in/api";
		given().
			get("/users?page=2").
		then().
			statusCode(200);
		
	}

}
