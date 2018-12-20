package com.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CheckRecord{
	public int checkRecord(int regNum, String password){
		int result = 0;
	try {
		//step1: load the driver
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		//step2 : establish connection
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "root");
		
		
		//step3: prepare the statement
		PreparedStatement ps = con.prepareStatement("select * from register where regnumber = ?");
		ps.setInt(1, regNum);

		//step4: execute the statement
		ResultSet rs = ps.executeQuery();
		if(rs.getString(6).equals(password)){
			result = 1;
		}else{
			result= 0;
		}
		
		//step5: close statement and connection
		ps.close();
		con.close();
	} catch (ClassNotFoundException | SQLException e) {
		// TODO Auto-generated catch block
	
		e.printStackTrace();
	}
	return result;
}
}



