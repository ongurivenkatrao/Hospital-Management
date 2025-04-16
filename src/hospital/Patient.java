package hospital;
import java.io.BufferedReader;
import java.io.IOException;
import java.sql.*;

public class Patient {
	
	Connection con;
	BufferedReader br;
	
	Patient(Connection con,BufferedReader br)
	{
		this.con=con;
		this.br=br;
	}
	public void AddpatientDetails() throws SQLException, IOException
	{
		System.out.println("Enter the patient id");
		int pid=Integer.parseInt(br.readLine());
		System.out.println("Enter the patient Name");
		String pname=br.readLine();
		System.out.println("Enter the patient Address");
		
		String paddress=br.readLine();
		System.out.println("Enter the PMobile");
		String pMobile=br.readLine();
		String query="insert into patient values(?,?,?,?)";
		PreparedStatement smt=con.prepareStatement(query);
		smt.setInt(1, pid);
		smt.setString(2, pname);
		smt.setString(3, paddress);
		smt.setString(4, pMobile);
		smt.executeUpdate();
		
	}
	public void viewpatientDetails() throws SQLException
	{
		String query="select * from patient";
		PreparedStatement smt=con.prepareStatement(query);
		ResultSet res=smt.executeQuery();
		System.out.println("-------------+------------+---------------------+----------------");
		System.out.println("PatientId      PatientName      PatientAddress    PatientMobile");
		System.out.println("-------------+------------+---------------------+----------------");
		while(res.next())
		{
			System.out.println(res.getInt(1)+"\t"+res.getString(2)+"\t "+res.getString(3)+"\t"+res.getString(4));
		}
	}

}
