package apireusabilities;

import java.util.HashMap;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class RestUtilis {
	public static Response postReq(HashMap<String,String>payload,HashMap<String,String>headers, String endpoint)
	{
		return RestAssured.given().headers(headers).when().body(payload).post(endpoint);
}
	public static Response getReq(HashMap<String,String>headers,String endPoint)
	{
		return RestAssured.given().headers(headers).when().get(endPoint);
	}
	public static Response postReq(String payload,HashMap<String,String>headers, String endpoint)
	{
		return RestAssured.given().headers(headers).when().body(payload).post(endpoint);
}
	public static Response putReq(String payload,HashMap<String,String>headers, String endpoint)
	{
		return RestAssured.given().headers(headers).when().body(payload).post(endpoint);
}
	public static Response DeleteReq(String payload,HashMap<String,String>headers, String endpoint)
	{
		return RestAssured.given().headers(headers).when().body(payload).post(endpoint);
}
}


