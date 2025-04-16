package hospital;

import java.io.BufferedReader;
import java.io.IOException;

import java.io.InputStreamReader;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class Main {
	   static String driver="com.mysql.cj.jdbc.Driver";
	   static String url="jdbc:mysql://localhost:3306/hospitalmanagement";
	   static String username="root";
	   static String password="Password";
	      static InputStreamReader ins=new InputStreamReader(System.in);
		static   BufferedReader br=new BufferedReader(ins);
	public static void main(String[] args) throws ClassNotFoundException, SQLException, NumberFormatException, IOException {
		// TODO Auto-generated method stub
		 
		  //Register the Driver
		  Class.forName(driver);
		  
		  //Establish the connection
		  Connection con=DriverManager.getConnection(url, username, password);
		    while(true)
		    {
		     System.out.println("1.Add the Patient Details");
			 System.out.println("2.View the Patient Details");
			 System.out.println("3.Add the Doctor Details");
			 
			 System.out.println("4.View the Doctor Details");
			 System.out.println("5.Exit");
			 System.out.println("Enter the option");
		 int  op=Integer.parseInt(br.readLine());
		    
		 Patient p=new Patient(con,br);
		 Doctor d=new Doctor(con,br);
		 switch(op)
		 {
		 case 1:
		       
		        p.AddpatientDetails();
		        break;
		 case 2:
		        p.viewpatientDetails();
		        break;
		 case 3:
		         d.adddoctordetails();
		         break;
		 case 4:
		          d.viewdoctordetails();
		          break;
		 case 5:System.out.println("Thank you for visting the Hospital");
		         break;
		        
		 }
		      
		 
		 }
		 
	} 

	}


