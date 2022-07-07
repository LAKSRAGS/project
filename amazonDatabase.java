package project;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class amazonDatabase
{
	
	public static void main(String[] args)throws ClassNotFoundException,SQLException
	{
		String dburl="jdbc:mysql://localhost:3306/amazonDB";
		String username="root";
		String password="root";
		String query="{call SelectAllProduct1s()}";
		Connection con=null;
		 try {
		Class.forName("com.mysql.cj.jdbc.Driver");
	 con= DriverManager.getConnection(dburl, username, password);
		Statement stmt=con.createStatement();
		ResultSet rs=stmt.executeQuery(query);
		//ResultSet rs1=stmt.executeQuery(query1);
		while(rs.next())
		{
			System.out.print("PROID:  "+rs.getString("PROID")+"\t");
			System.out.print("PRONAME: "+rs.getString("PRONAME")+"\t");
			System.out.print("YEAR  "+rs.getString("YEAR")+"\t");
			System.out.print("SPECIFICATION "+rs.getString("SPECIFICATION")+"\t");
			
			System.out.println();
		}
		 }
			//while(rs1.next())
		catch(SQLException e)
		{
			System.out.println(e.getMessage());
		}
	
	finally
	{
		con.close();
		}
	
	
}
}

