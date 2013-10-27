package com.test.classes;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCConnection {

	public static void main(String[] args) {
		
		Connection con = null;
		
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			
			String url = "jdbc:mysql://localhost:3306/ortva";
			con = DriverManager.getConnection(url, "root", "");
			
		} catch(Exception e) 
		{
			System.err.println(e.getMessage());
			e.printStackTrace();
		}
		
		if(con == null)
			System.err.println("Cannot connect");
		
		System.out.println("I'm in!");
		
		Statement stmt = null;
		String query = "SELECT * FROM restaurant";
	    try {
	        stmt = con.createStatement();
	        ResultSet rs = stmt.executeQuery(query);
	        
	        System.out.println("Restaurants :");
	        
	        while (rs.next()) {
	            int id = rs.getInt("num_restaurant");
	            String type1 = rs.getString("typerestau1");
	            String type2 = rs.getString("typerestau2");

	            System.out.println(id + " " + type1 + " " + type2);
	        }
	    } catch (SQLException e ) {
	        e.printStackTrace();
	    }
	}

}
