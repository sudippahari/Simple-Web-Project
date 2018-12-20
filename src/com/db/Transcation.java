package com.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Transcation {

	public int getAmount() throws SQLException {
		ResultSet rs = null;
		try {
			// step1: load the driver
			Class.forName("com.mysql.cj.jdbc.Driver");

			// step2 : establish connection
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "root");

			// step3: prepare the statement
			PreparedStatement ps = con.prepareStatement("select * from transaction");

			// step4: execute the statement
			rs = ps.executeQuery();

			// step5: close statement and connection
			ps.close();
			con.close();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block

			e.printStackTrace();
		}
		return rs.getInt(1);
	}

	public void deduct(int amount, int balance) {
		try {
			// step1: load the driver
			Class.forName("com.mysql.cj.jdbc.Driver");

			// step2 : establish connection
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "root");
			con.setAutoCommit(false);
			// step3: prepare the statement
			PreparedStatement ps = con.prepareStatement("update transaction set balance = ?");
			ps.setInt(1, balance - amount);

			// step4: execute the statement
			int n = ps.executeUpdate();
			con.commit();
			
			if (n != 0) {
				System.out.println("Balance successfully updated");
			} else {
				System.out.println("Updation not successful");
				con.rollback();
			}

			// step5: close statement and connection
			ps.close();
			con.close();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block

			e.printStackTrace();
		}

	}
}
