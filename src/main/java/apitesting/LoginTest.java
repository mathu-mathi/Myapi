package apitesting;

	import static org.junit.Assert.assertThat;

	import java.io.File;
	import java.io.IOException;
	import java.util.HashMap;
	import java.util.List;

	import org.testng.Assert;
	import org.testng.annotations.BeforeClass;
	import org.testng.annotations.Test;

	import com.fasterxml.jackson.core.JsonProcessingException;
	import com.jayway.jsonpath.JsonPath;

	import api.testData.AddUser;
import api.testData.UpdateUser;
import apiConstant.FileConstant;
	import apiUtilis.CommonUtilis;
	import apireusableutilis.RestUitils;
	import io.restassured.RestAssured;
	import io.restassured.response.Response;
	//import static io.restassured.module
	import  org.hamcrest.MatcherAssert.*;
	import  org.hamcrest.Matchers.*;
	public class LoginTest extends ApiBaseTest {
		@BeforeClass
		public void setUri() throws IOException
		{
			String uri=CommonUtilis.readFile(FileConstant.URI_FILEPATH);
			RestAssured.baseURI=JsonPath.read(uri,"$.login.prod");
			System.out.println(RestAssured.baseURI);
		}
	@Test(enabled=false)
	public void loginTC_01()
	{	
		//RestAssured.baseURI="https://us-central1-qa01-tekarch-accmanager.cloudfunctions.net";
		/*Response res= RestAssured.given().headers("Content-Type","application/json").when().body("{\r\n" + 
				"\"username\": \"mathu@tekarch.com\",\r\n" + 
				"\"password\": \"Admin123\"\r\n" + 
				"}").post("/login").then().assertThat().statusCode(200).extract().response();
		System.out.println(res.asPrettyString());*/
		HashMap<String,String>headers=new HashMap<>();
		headers.put("Token",token);
		headers.put("Content-Type","application/json");
		
		HashMap<String,String>logincreds=new HashMap<>();
		logincreds.put("username","mathu@tekarch.com");
		logincreds.put("password","Admin123");
		Response res1=RestUitils.postReq(logincreds, headers,"/login"); 
		 //  res1.then().assertThat().body(matchesjsonSchema(new File(FileConstant.LOGIN_SCHEMA)));
		Assert.assertEquals(res1.statusCode(),201);
		//Response res1=RestAssured.given().contentType(ContentType.JSON).when().body(logincreds).post("/login");
		System.out.println(res1.asPrettyString());
		
	     //token=res1.jsonPath().getString("token").replace("[","").replace("]","");
		//System.out.println(token);
	}
		@Test(enabled=true)
		public void getData_TC02()
		{
		HashMap<String,String>headers=new HashMap<>();
		headers.put("Token",token);
		headers.put("Content-Type","application/json");
		Response getUserData=RestUitils.getReq(headers, "/getdata");
		//Response getUserData=RestAssured.given().headers(headers).when().get("/getdata");
		System.out.println(getUserData.prettyPrint());
		List<String> accountnumber=getUserData.jsonPath().getList("accountno");
		System.out.println(accountnumber.size());
		//AssertThat(accountnumber.size(),greaterThan(1000));
		
		
		}
		@Test(enabled=false)
		public void addData_TC02() throws JsonProcessingException
		{
			HashMap<String,String>headers=new HashMap<>();
			headers.put("Token",token);
			headers.put("Content-Type","application/json");
		//HashMap<String,String>payload=new HashMap<>();
		//payload.put("accountno","");
		//payload.put("departmentno","");
		//payload.put("salary","");
		//payload.put("pincode","");
			AddUser mathu=new AddUser("TA-1234587","7","4000","56324356");
		  String sPayload=CommonUtilis.serializeObject(mathu);
			Response addData=RestUitils.postReq(sPayload, headers, "/addData/");
		System.out.println(addData.prettyPrint());
		//System.out.println(res1.asString());
	        }
		public void update_TC03()
		{
			HashMap<String,String>headers=new HashMap<>();
			headers.put("Token",token);
			headers.put("Content-Type","application/json");
		//HashMap<String,String>payload=new HashMap<>();
		//payload.put("accountno","");
		//payload.put("departmentno","");
		//payload.put("salary","");
		//payload.put("pincode","");
			UpdateUser mathu=new UpdateUser("TA-1234587","7","4000","56324356");
		  String sPayload=CommonUtilis.serializeObject(mathu);
			Response UpdateData=RestUitils.putReq(sPayload, headers, "/UpdateData/");
		System.out.println(UpdateData.prettyPrint());
		//System.out.println(res1.asString());
			
		}
		public void delete_TC04()
		{
			HashMap<String,String>headers=new HashMap<>();
			headers.put("Token",token());
			headers.put("Content-Type","application/json");
			//UpdateUser mathu=new UpdateUser("TA-1234587","7","4000","56324356");
			  //String sPayload=CommonUtilis.serializeObject(mathu);
			//Response deleteData = RestUitils.deleteReq(sPayload, headers, "/DeleteData"); // Replace with your endpoint    
		
	
			 
			  //Calling the Delete API with request body
			  Response res = RestAssured.delete("/TA-1234587\",\"7\",\"4000\",\"56324356");
		 
			  //Fetching the response code from the request and validating the same
			  System.out.println("The response code is - " +res.getStatusCode());
		      Assert.assertEquals(res.getStatusCode(),204);
		     // System.out.println(DeleteData.prettyPrint());
	}
		
}
