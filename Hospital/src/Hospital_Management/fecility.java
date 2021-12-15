package Hospital_Management;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

	public class fecility implements fecilityInterface
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
	    public void add_feci()
	    {
	       Connection c=getConnection();
	       Scanner input = new Scanner(System.in);
	       System.out.print("pharmacy:-");
	       String  pharmacy = input.nextLine();
	       System.out.print("ward:-");
	       String ward  = input.nextLine();
	       System.out.print("dressing_room:-");
	       String dressing_room  = input.nextLine();
	       System.out.print("ambulance:-");
	       String ambulance  = input.nextLine();
	       System.out.print("laboratory:-");
	       String laboratory  = input.nextLine();
	       System.out.print("ecg_service:-");
	       String ecg_service  = input.nextLine();
	       System.out.print("x_ray:-");
	       String x_ray  = input.nextLine();
	       System.out.print("physiotherapy:-");
	       String physiotherapy  = input.nextLine();
	       
	       
	        try {
		    	 Statement st = c.createStatement();
				ResultSet rs2 = st.executeQuery("Select * from facility");
				st.executeUpdate("Insert into facility(pharmacy,ward,dressing_room,ambulance,laboratory,ecg_service,x_ray,physiotherapy) values('"+pharmacy+"','"+ward+"','"+ dressing_room+"','"+ ambulance+"','"+laboratory +"','"+ ecg_service+"','"+x_ray +"','"+physiotherapy+"')");
			    System.out.println("Data Entered Successfully");

			} catch (SQLException e) {
				
				e.printStackTrace();
			}
	    }
	    
	 public void show_feci()
	    {
	    	try {
	    		Connection c=getConnection();
		    	 Statement st = c.createStatement();
				ResultSet rs = st.executeQuery("Select * from facility");
				
				while(rs.next()) {
					System.out.println(rs.getString(1)+ "\t\t"+rs.getString(2)+"\t\t"+rs.getString(3)+"\t"+rs.getString(4)+"\t"+rs.getString(5)+"\t\t"+rs.getString(6)+"\t"+ rs.getString(7)+"\t"+rs.getString(8));
				}
	    	}
catch (SQLException e) {
				
				e.printStackTrace();
			}
		    
	}
	public class fecititytemp extends fecility {
	       void dynamic(){
	           System.out.println("This statement can't be accessible");
	       }
	}
	
	}
