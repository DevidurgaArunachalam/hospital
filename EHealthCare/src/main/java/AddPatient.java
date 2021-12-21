import java.sql.*;
import java.util.*;
public class AddPatient extends EHC {
   Connection c =null;
  public Connection getConnection() throws SQLException{
	  
	  c = DriverManager.getConnection("jdbc:mysql://localhost:3306/project", "root", "Deepi@123");
	  return c;
  }
public void registerinfo() throws SQLException{
	AddPatient obj = new AddPatient();
Connection c = getConnection();
	Statement st = c.createStatement();
	
	Scanner sc=new Scanner(System.in);
	System.out.println("Enter patientID \t\t name \t\t contactNumber \t\t gender \t\t age \t\t bloodGroup \t\t address \t\t anyMajorDisease");
	String patientID = sc.next();
	String name = sc.next();
	String contactNumber = sc.next();
	String gender = sc.next();
	String age= sc.next();
	String bloodGroup = sc.next();
	String address = sc.next();
	String anyMajorDisease = sc.next();
	
	
	
	
}
	
	
}
