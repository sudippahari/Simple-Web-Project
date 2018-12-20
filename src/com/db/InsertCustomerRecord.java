package com.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class InsertCustomerRecord {

	public void insert(int regNum, String name, String address, String email, int number, String password ){
		try {
			//step1: load the driver
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			//step2 : establish connection
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "root");
			
			//step3: prepare the statement
			PreparedStatement ps = con.prepareStatement("insert into register values(?,?,?,?,?,?)");
			ps.setInt(1, regNum);
			ps.setString(2, name);
			ps.setString(3, address);
			ps.setString(4, email);
			ps.setInt(5, number);
			ps.setString(6, password);

			//step4: execute the statement
			int n = ps.executeUpdate();
			
			if(n != 0){
				System.out.println("One cutomer record successfully inserted");
				
			}else{
				System.out.println("Insertion not successful");
				}
			
			//step5: close statement and connection
			ps.close();
			con.close();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
		
			e.printStackTrace();
		}
	
	}
}
