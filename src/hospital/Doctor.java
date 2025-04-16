package hospital;
import java.io.BufferedReader;
import java.io.IOException;
import java.sql.*;


public class Doctor {
	Connection con;
	BufferedReader br;

	

	public Doctor(Connection con, BufferedReader br) {
		// TODO Auto-generated constructor stub
		this.con = con;
		this.br = br;
	}

	public void adddoctordetails() throws SQLException, IOException {
		System.out.println("Enter the Doctor Id");
		int did=Integer.parseInt(br.readLine());
		System.out.println("Enter the Doctor Name");
		String dname=br.readLine();
		System.out.println("Enter the Doctor Designitaion");
		String desination=br.readLine();
		System.out.println("Enter the Doctor Experienece");
		int exp=Integer.parseInt(br.readLine());
		String query="Insert into doctor values(?,?,?,?)";
		PreparedStatement smt=con.prepareStatement(query);
		smt.setInt(1, did);
		smt.setString(2, dname);
		smt.setString(3, desination);
		smt.setInt(4, exp);
		smt.executeUpdate();
		
	}
	public void viewdoctordetails() throws SQLException
	{
		String query="select * from doctor";
		PreparedStatement smt=con.prepareStatement(query);
		ResultSet res=smt.executeQuery();
		System.out.println("-------------+------------+---------------------+----------------");
		System.out.println("Doctor Id      DcotorName      DoctorDesignation    DoctorExp");
		System.out.println("-------------+------------+---------------------+----------------");
		while(res.next())
		{
			System.out.print(res.getInt(1)+"\t"+res.getString(2)+"\t "+res.getString(3)+"\t "+res.getInt(4));
			System.out.println();
		}

	}
	
}
