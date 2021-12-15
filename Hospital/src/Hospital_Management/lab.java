

package Hospital_Management;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

	public class lab implements labInterface
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
		
	     
	    public void new_feci()
	    {
	    	 Connection c= getConnection();
	        Scanner input = new Scanner(System.in);
	        System.out.print("facility:-");
	        String facility = input.nextLine();
	        System.out.print("cost:-");
	        int  lab_cost = input.nextInt();
	        
	        try
	        {
	         Statement st=c.createStatement();
	        ResultSet rs2=st.executeQuery("select *from lab");
	         st.executeUpdate("Insert into lab(facility,lab_cost) values('"+ facility +"','"+ lab_cost +"')");
	         System.out.println("Data entered Successfully");	
	        
	      
	              	
	        }
	        catch(Exception e) {
	        	 e.printStackTrace();	
	        }
	    }
	    public void feci_list()
	    {

	        try {
	    		Connection c=getConnection();
		    	 Statement st = c.createStatement();
				ResultSet rs = st.executeQuery("Select * from lab");
				
				while(rs.next()) {
					System.out.println(rs.getString(1)+" \t\t\t"+rs.getInt(2));
				}
	    	}
	catch (SQLException e) {
				
				e.printStackTrace();
			}
	    }
	    
	}


