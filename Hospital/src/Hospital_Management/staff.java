	package Hospital_Management;

	import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

	public class staff implements staffInterface
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
		
	     
	    public void new_staff()
	    {
	    	 Connection c= getConnection();
	        Scanner input = new Scanner(System.in);
	        System.out.println("sid:-");
	        int sid = input.nextInt();
	        System.out.println("sname:-");
	        String  sname = input.next();
	        System.out.println("gender:-");
	        String gender = input.next();
	        System.out.println("desg:-");
	        String desg = input.next();
	        System.out.println("salary:-");
	        int salary = input.nextInt();
	        
	        try
	        {
	         Statement st=c.createStatement();
	        ResultSet rs2=st.executeQuery("select *from lab");
	         st.executeUpdate("Insert into staff(sid,sname,gender,desg,salary) values('"+ sid +"','"+ sname +"','"+gender+"','"+desg+"','"+salary+"')");
	         System.out.println("Data entered Successfully");	
	        
	      
	              	
	        }
	        catch(Exception e) {
	        	 e.printStackTrace();	
	        }
	    }
	    public void staff_list()
	    {

	        try {
	    		Connection c=getConnection();
		    	 Statement st = c.createStatement();
				ResultSet rs = st.executeQuery("Select * from staff");
				
				while(rs.next()) {
					System.out.println(rs.getInt(1)+" \t "+rs.getString(2)+"\t "+rs.getString(3)+"\t\t"+rs.getString(4)+"\t\t"+rs.getInt(5));
				}
	    	}
	catch (SQLException e) {
				
				e.printStackTrace();
			}
	    }
	    
	}




