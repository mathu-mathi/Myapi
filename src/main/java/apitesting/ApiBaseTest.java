package apitesting;

public class ApiBaseTest {
	public static String token;
	public static void setToken() throws IOException
	{
		String uri=CommonUtilis.readFile(FileConstant.URI_FILEPATH);
		RestAssured.baseURI=JsonPath.read(uri,"$.login.prod");
		String creds=CommonUtilis.readFile(FileConstant.USER_CONFIG_FILEPATH);
		String un=JsonPath.read(creds, "$.prod.username");
		String pw=JsonPath.read(creds, "$.prod.password");
		HashMap<String,String>payload=new HashMap<>();
		payload.put("username",un);
		payload.put("password",pw);
		HashMap<String,String>headers=new HashMap<>();
		headers.put("Content-Type","application/json");
		Response res=RestUitils.postReq(payload, headers,"/login");
		System.out.println(res.asPrettyString());
		token=JsonPath.read(res.asString(),"$.[0].token");
	}
		@BeforeTest
		public void setUp() throws IOException
		{
			ApiBaseTest.setToken();
		}
		
	}

}

}
