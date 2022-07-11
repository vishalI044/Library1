package com;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
	public static Connection initialise() throws SQLException, ClassNotFoundException {

		//String dbdriver = "com.mysql.jdbc.Driver";
		//String dburl = "jdbc:mysql://localhost:3306/employee_database";
		//String dbusername = "root";
		//String dbpassword = "Vishal@123";
		Class.forName("com.mysql.jdbc.Driver");
		
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/employee_database", "root", "Vishal@123");

		return conn;
	}
}
