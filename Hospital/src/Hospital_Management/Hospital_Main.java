	package Hospital_Management;

	import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;

	import Hospital_Management.*;
	
	interface DoctorInterface{
		void new_doctor();
		void doctor_info();
	}

	interface medicalInterface{
	    void new_medi();
	    void show_medi();
	}
	interface fecilityInterface{
	    void add_feci();
	    void show_feci();
	}
	interface patientInterface{
	    void new_patient();
	    void show_patient();
	}
	interface labInterface{
	    void new_feci();
	    void feci_list();
	}
	interface staffInterface{
	    void new_staff();
	    void staff_list();
	}
	class AuthenticationException extends Exception {
	    public AuthenticationException(String message)
	    {
	        super(message);
	    }
	}
	
	public class Hospital_Main
	{
		 Connection c=null;
	    public  Connection getConnection() {
	    	
	    	try {
	    		Connection c=getConnection();
	    	c = DriverManager.getConnection("jdbc:mysql://localhost:3306/hospital", "root", "Deepi@123");
	    	} catch (Exception e) {
	    	System.out.println(e);
	    	}
	    	return c;
	    	}
	    public static void main(String args[]) throws SQLException
	    {    
	        InputStreamReader isr = new InputStreamReader(System.in);
	        BufferedReader br = new BufferedReader(isr);
	        String pwd;
	        try {

	            System.out.print("Enter password :: ");
	            pwd = br.readLine();

	            if (!pwd.equalsIgnoreCase("deepi@123"))
	                throw new AuthenticationException("Incorrect password\nType correct password");
	            else {
	                System.out.println("Welcome User !!!");
	                int count1 = 0, count2 = 0, count3 = 0, count4 = 0, count5 = 0, count6 = 0;
	                System.out.println("\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
	                System.out.println("             Welcome to Hospital Management System Project in Java   ");
	                System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");

	                Doctor[] d = new Doctor[25];
	                Patient[] p = new Patient[100];
	                lab[] l = new lab[20];
	                fecility[] f = new fecility[20];
	                medical[] m = new medical[100];
	                staff[] s = new staff[100];

	                int i;
	                for (i = 0; i < 25; i++)
	                    d[i] = new Doctor();
	                for (i = 0; i < 100; i++)
	                    p[i] = new Patient();
	                for (i = 0; i < 20; i++)
	                    l[i] = new lab();
	                for (i = 0; i < 20; i++)
	                    f[i] = new fecility();
	                for (i = 0; i < 100; i++)
	                    m[i] = new medical();
	                for (i = 0; i < 100; i++)
	                    s[i] = new staff();

	                Scanner input = new Scanner(System.in);
	                int choice, j, c1, status = 1, s1 = 1, s2 = 1, s3 = 1, s4 = 1, s5 = 1, s6 = 1;
	                while (status == 1) {
	                    System.out.println("\nMAIN MENU");
	                    System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
	                    System.out.println("1. Doctors \n2. Patients \n3. Medicines \n4. Laboratories \n5. Facilities \n6. Staff \n7. Exit");
	                    System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
	                    choice = input.nextInt();

	                    switch (choice) {
	                        case 1: {
	                            System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
	                            System.out.println("                        DOCTOR SECTION");
	                            System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
	                            s1 = 1;
	                            if(s1 == 1) {
	                                System.out.println("1.Add New Entry\n2.Existing Doctors List");
	                                c1 = input.nextInt();
	                                switch (c1) {
	                                    case 1: {
	                                    	 Doctor a=new Doctor();
	       	                              a.new_doctor();
	       	                              break;
	                                    }
	                                    case 2: {
	                                    	
	                                        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
	                                        System.out.println("id \t\t Name\t\tSpecilist\tTiming\t\tQualification\tRoom No.");
	                                        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
	                              Doctor a=new Doctor();
	                              a.doctor_info();
	                                        }
	                                        break;
	                                    }
	                                System.out.println("\nReturn to Back Press 1 and for Main Menu Press 0");
	                                s1 = input.nextInt();
	                                }
	                                
	                            }
	                            break;
	                    
	                
	                        case 2: {
	                            System.out.println("--------------------------------------------------------------------------------");
	                            System.out.println("                     **PATIENT SECTION**");
	                            System.out.println("--------------------------------------------------------------------------------");
	                            s2 = 1;
	                            if (s2 == 1) {
	                                System.out.println("1.Add New Entry\n2.Existing Patients List");
	                                c1 = input.nextInt();
	                                switch (c1) {
	                                    case 1: {
	                                    	Patient a=new Patient();
	       	                              a.new_patient();
	       	                              break;
	                                    }
	                                    case 2: {
	                                        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
	                                        System.out.println("pid\t pname\t   gender\t contact_no\taddress\t\tdisease\t\tadmit_status\tward_req");
	                                        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
	                                    	Patient a=new Patient();
		       	                              a.show_patient();
		       	                              
	                                    }
	                                    break;
	                                }
	                                System.out.println("\nReturn to Back Press 1 and for Main Menu Press 0");
	                                s2 = input.nextInt();
	                            }
	                            break;
	                        }
	                        case 3: {
	                            s3 = 1;
	                            System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
	                            System.out.println("                         MEDICINE SECTION");
	                            System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
	                            if (s3 == 1) {
	                                System.out.println("1.Add New Entry\n2. Existing Medicines List");
	                                c1 = input.nextInt();
	                                switch (c1) {
	                                    case 1: {
	                                    	medical a=new medical();
		       	                              a.new_medi();
		       	                              break;
	                                    }
	                                    case 2: {
	                                        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
	                                        System.out.println("Name \t\tCompany \t\t Expiry Date \t\t Cost \t\tCount");
	                                        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
	                                        medical a=new medical();
		       	                              a.show_medi();
	                                    }
	                                   break;
	                                }
	                                System.out.println("\nReturn to Back Press 1 and for Main Menu Press 0");
	                                s3 = input.nextInt();
	                            }
	                            break;
	                        }
	                        case 4: {
	                            s4 = 1;
	                            System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
	                            System.out.println("                      LABORATORY SECTION");
	                            System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
	                            if (s4 == 1) {
	                                System.out.println("1.Add New Entry \n2.Existing Laboratories List");
	                                c1 = input.nextInt();
	                                switch (c1) {
	                                    case 1: {
	                                    	lab a=new lab();
		       	                              a.new_feci();
		       	                              break;
	                                       
	                                    }
	                                    case 2: {
	                                        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
	                                        System.out.println("Facilities\t\t Cost");
	                                        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
	                                        
	                                        lab a=new lab();
		       	                              a.feci_list();
	                                        
	                                        }
	                                        break;
	                                    }
	                                System.out.println("\nReturn to Back Press 1 and for Main Menu Press 0");
	                                s4 = input.nextInt();
	                                }
	                            
	                               
	                            }
	                            break;
	                        
	                        case 5: {
	                            s5 = 1;
	                            System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
	                            System.out.println("          HOSPITAL FACILITY SECTION");
	                            System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
	                            if (s5 == 1) {
	                                System.out.println("1.Add New Facility\n2.Existing Fecilities List");
	                                c1 = input.nextInt();
	                                switch (c1) {
	                                    case 1: {
	                                    	 fecility a=new fecility();
	       	                              a.add_feci();
	       	                              break;
	                                    }
	                                    case 2: {
	                                        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
	                                        System.out.println("pharmacy\tward\t\tdressing_room\tambulance\tlaboratory\tecg_service\tx_ray\t\tphysiotherapy");
	                                        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~") ;                                      
	                                        fecility a=new fecility();
		       	                              a.show_feci();
	                                    }
	                                    break;
	                                }
	                                System.out.println("\nReturn to Back Press 1 and for Main Menu Press 0");
	                                s5 = input.nextInt();
	                            }
	                           
	                        }
	                        break;
	                        case 6: {
	                            s6 = 1;
	                            System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
	                            System.out.println("                         STAFF SECTION");
	                            System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
	                            if (s6 == 1) {
	                                
	                                System.out.println("1.Add New Entry \n2.Existing List");
	                                c1 = input.nextInt();
	                                switch (c1) {
	                                    case 1: {
	                                   staff a= new staff();
	                                   a.new_staff();
	                                   break;
	                                    }
	                                    case 2: {
	                                      	                                    
	                                        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
	                                        System.out.println("id \t Name \t Gender \t Salary");
	                                        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
	                                        for (j = 0; j < count6; j++) {
	                                        	staff a= new staff();
	 	 	                                   a.staff_list();	
	                                        }
	                                        break;
	                                    }
	                                    
	                                }
	                                System.out.println("\nReturn to Back Press 1 and for Main Menu Press 0");
	                                s6 = input.nextInt();
	                            }
	                            break;
	                        }
	                        case 7: {
	                        	
	                            System.exit(0);
	                        }

	                        default: {
	                            System.out.println(" You Have Enter Wrong Choice!!!");

	                        }
	                    }
	                    System.out.println("\nReturn to MAIN MENU Press 1");
	                    status = input.nextInt();
	                }
	            }
	        }
	        catch (IOException e) {
	            e.printStackTrace();
	        }
	        catch (AuthenticationException a) {
	            a.printStackTrace();
	        }
	    }
	}
	


