package apiUtilis;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;

import api.testData.AddUser;

public class CommonUtilis {
	public static String readFile(String filePath) throws IOException
	 {
		 byte[] fileContent=Files.readAllBytes(Paths.get(filePath));
		return new String(fileContent,StandardCharsets.UTF_8);
		 
	 }
	 //To convert object to string and return the same
	 public static String serializeObject(Object user) throws JsonProcessingException
	{
	ObjectMapper om=new ObjectMapper();
	om.setPropertyNamingStrategy(PropertyNamingStrategies.LOWER_CASE);
	String sjsonPayload=om.writeValueAsString(user);
	System.out.println(sjsonPayload);
	return sjsonPayload;

	}
	 //convert json string to object the the input parameter could be string
	 public static Object deserialization(String sJson) throws JsonMappingException, JsonProcessingException
	 {
		//convert back to the same kind of an object
		 ObjectMapper om=new ObjectMapper();	
		 AddUser au=om.readValue(sJson,AddUser.class);
				 return au;
	 }  
	 }

