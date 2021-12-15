	package Hospital_Management;
	import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
	
public	class Doctor implements DoctorInterface{
	    String did, dname, specilist, appoint, doc_qual;
	    int droom;
	    Connection c=null;
	    public Connection getConnection() {
	    	
	    	try {
	    	c = DriverManager.getConnection("jdbc:mysql://localhost:3306/hospital", "root", "Deepi@123");
	    	} catch (Exception e) {
	    	System.out.println(e);
	    	}
	    	return c;
	    	}
	  public  void new_doctor()
	    {
	    	Connection c=getConnection();
	        Scanner input = new Scanner(System.in);
	        System.out.print("id:-");
	        did = input.nextLine();
	        System.out.print("name:-");
	        dname = input.nextLine();
	        System.out.print("specilization:-");
	        specilist = input.nextLine();
	        System.out.print("work time:-");
	        appoint = input.nextLine();
	        System.out.print("qualification:-");
	        doc_qual = input.nextLine();
	        System.out.print("room no.:-");
	        droom = input.nextInt();
	       
		    try {
		    	 Statement st = c.createStatement();
				ResultSet rs2 = st.executeQuery("Select * from hospital");
				st.executeUpdate("Insert into hospital(did,dname,specilist,appoint,doc_qual,droom) values('" + did + "','" + dname + "','" + specilist + "','" + appoint + "','" + doc_qual+ "','" + droom + "')");
			    System.out.println("Data Entered Successfully");

			} catch (SQLException e) {
				
				e.printStackTrace();
			}
		    
		   
	    }
	    	    
	   public void doctor_info()
	    {
	    	try {
	    		Connection c=getConnection();
		    	 Statement st = c.createStatement();
				ResultSet rs = st.executeQuery("Select * from hospital");
			
				while(rs.next()) {
   					System.out.println(rs.getString(1)+"\t\t" +rs.getString(2)+"\t\t" + rs.getString(3) + "\t\t" + rs.getString(4) + "\t\t" + rs.getString(5) + "\t\t"+ rs.getString(6) + "\t\t");
   				}
	    	}
catch (SQLException e) {
				
				e.printStackTrace();
			}
		    
	}
	public class Doctortemp extends Doctor {
	       void dynamic(){
	           System.out.println("This statement can't be accessible");
	       }
	}
	}


