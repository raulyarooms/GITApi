package org.yarooms.apitesting;

import org.yarooms.framework.*;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.FixMethodOrder;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.runner.JUnitCore;
import org.junit.runners.MethodSorters;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import junit.framework.Assert;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.hasItems;

import org.hamcrest.Matchers;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.experimental.ParallelComputer;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TestAuthentication extends GINUtils {
	
	//@Test
	public void Test1_ValidAccount()
	{
		RestAssured.baseURI = apiURL;
		RequestSpecification request = RestAssured.given();
		
		request.header("Authorization", "Bearer " + apiKEY);
		
		Response response = request.get("/user");

		int statusCode = response.getStatusCode();		
		JsonPath jsonPathEvaluator = response.jsonPath();		
		String id = jsonPathEvaluator.get("id");

		System.out.println("STATUS CODE: " + statusCode);
		System.out.println("Response body: " + response.body().asString());
		//System.out.println("ID " + id);
	}

	//@Test
	public void Test2_InvalidAccount_WrongAPIKey()
	{
		RestAssured.baseURI = apiURL;
		RequestSpecification request = RestAssured.given();
		
		request.header("Authorization", "Bearer RANDOM");
		
		Response response = request.get("/user");

		int statusCode = response.getStatusCode();		
		JsonPath jsonPathEvaluator = response.jsonPath();		
		String id = jsonPathEvaluator.get("id");

		System.out.println("STATUS CODE: " + statusCode);
		System.out.println("Response body: " + response.body().asString());
	}
	
	@Test
	public void Test3_GetTransactions()
	{
		RestAssured.baseURI = apiURL;
		RequestSpecification request = RestAssured.given();
		
		request.header("Authorization", "Bearer " + apiKEY);
		
		Response response = request.get("/user/transactions");

		int statusCode = response.getStatusCode();		
		JsonPath jsonPathEvaluator = response.jsonPath();		
		String id = jsonPathEvaluator.get("id");

		System.out.println("STATUS CODE: " + statusCode);
		System.out.println("Response body: " + response.body().asString());
		
		String allBalances = response.jsonPath().getString("list.balance");
		System.out.println(allBalances);
		System.out.println(allBalances.length());
		
		List<String> jsonResponse = response.jsonPath().getList("list.balance");
		System.out.println(jsonResponse.size());
	}
	
}
