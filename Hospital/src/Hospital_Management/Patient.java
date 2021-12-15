	
	package Hospital_Management;

	import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

	public  class Patient 
	{
		 Connection c=null;
		    public Connection getConnection() {
		    	
		    	try {
		    	c = DriverManager.getConnection("jdbc:mysql://localhost:3306/hospital", "root", "Deepi@123");
		    	} catch (Exception e) {
		    	System.out.println(e);
		    	}
		    	return c;
		    	}
	
	    String pid, pname, gender,address,disease, admit_status,ward_req;
	    float contact_no;
	    public void new_patient()
	    {
	    	Connection c=getConnection();
	        Scanner input = new Scanner(System.in);
	        System.out.print("id:-");
	        pid = input.nextLine();
	        System.out.print("name:-");
	        pname = input.nextLine();
	        System.out.print("gender:-");
	        gender = input.nextLine();
	        System.out.print("contact_no:-");
	        contact_no = input.nextFloat();
	        System.out.print("address:-");
	        address = input.next();
	        System.out.print("disease:-");
	        disease = input.next();
	        System.out.print("admit_status:-");
	        admit_status = input.nextLine();
	        System.out.print("ward_req:-");
	        ward_req = input.nextLine();
	    
        try {
	    	 Statement st = c.createStatement();
			ResultSet rs2 = st.executeQuery("Select * from patient");
	st.executeUpdate("Insert into patient(pid, pname, gender,contact_no,address,disease, admit_status,ward_req) "
			+ "values('"+pid+"','"+pname+"','"+gender+"','"+contact_no+"','"+address+"','"+disease+"','"+admit_status+"','"+ward_req+"')");
		    System.out.println("Data Entered Successfully");

		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	    }
	    
	    
    
        public void show_patient()
	    {
	    	try {
	    		Connection c=getConnection();
		    	 Statement st = c.createStatement();
				ResultSet rs = st.executeQuery("Select * from patient");
				
				while(rs.next()) {
					System.out.println(rs.getString(1)+ "      \t "+rs.getString(2)+"\t   "+rs.getString(3)+"  \t 0" +rs.getString(4)+"\t\t"+rs.getString(5)+"\t"+rs.getString(6)+"\t\t"+ rs.getString(7)+"\t\t"+rs.getString(8));
				}
	    	}
catch (SQLException e) {
				
				e.printStackTrace();
			}
		    
	}
	public class PatientTemp extends Patient {
	       void dynamic(){
	           System.out.println("This statement can't be accessible");
	       }
	}
	}

