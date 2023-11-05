package api.testData;

public class UpdateUser {
	private String accountno;
	private String departmentno;
	private String salary;
	private String pincode;
	public UpdateUser(String accountno,String departmentno,String salary,String pincode)
	{
		this.accountno="TA-1234587";
		this.departmentno="7";
		this.salary="5000";
		this.pincode="64104554";
	}
	public String getAccountNo()
	{
		return accountno;
	}
	public String getDepartmentNo()
	{
		return departmentno;
	}
	public String getSalary()
	{
		return salary;
	}
	public String getPinCode()
	{
		return pincode;
	}
}
