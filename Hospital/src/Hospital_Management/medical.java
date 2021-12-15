package Hospital_Management;
 import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class medical implements medicalInterface
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
    String med_name, med_comp, exp_date, med_cost;
    int count;
    public void new_medi()
    {
        Connection c= getConnection();
    	Scanner input = new Scanner(System.in);
        System.out.print("name:-");
       String med_name = input.next();
        System.out.print("company:-");
        String med_comp = input.next();
        System.out.print("expiry  date:-");
        String exp_date = input.next(); 
        System.out.print("cost:-");
        String med_cost = input.next();
        System.out.print("no of unit:-");
        int count = input.nextInt();
        
        
        try
        {
         Statement st=c.createStatement();
        ResultSet rs2=st.executeQuery("select *from medical");
         st.executeUpdate("Insert into medical(med_name,med_comp,exp_date,med_cost,count) values('"+ med_name +"','"+ med_comp +"','"+ exp_date +"','"+ med_cost +"','"+ count +"')");
         System.out.println("Data entered Successfully");	
        
      
              	
        }
        catch(Exception e) {
        	 e.printStackTrace();	
        }
    }
    public void show_medi()
    {
    	try {
    		Connection c=getConnection();
	    	 Statement st = c.createStatement();
			ResultSet rs = st.executeQuery("Select * from medical");
			
			while(rs.next()) {
				System.out.println(rs.getString(1)+" \t"+rs.getString(2)+"   \t "+rs.getString(3)+" \t\t " +rs.getString(4) +"\t\t" +rs.getString(5));
			}
    	}
catch (SQLException e) {
			
			e.printStackTrace();
		}
	    
}
public class medicaltemp extends medical {
       void dynamic(){
           System.out.println("This statement can't be accessible");
       }
}
}

