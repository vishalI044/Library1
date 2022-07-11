package com;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import com.mysql.cj.exceptions.MysqlErrorNumbers;

public class CreateEmployee {
	public static void createUser() throws ClassNotFoundException, SQLException {
		Scanner scan = new Scanner(System.in);
		Connection con = DBConnection.initialise();
		PreparedStatement st = null;
		int result;
		try {

			System.out.println("enter employeeID");
			int employeeID = scan.nextInt();

			System.out.println("employee Name:");
			String employeeName = scan.next();

			System.out.println("employee password :");
			String employeePass = scan.next();

			System.out.println("employee Salary");
			String employeeSalary = scan.next();

			System.out.println("employee type: 1. permanent | 2.parttime | 3.contract");
			int employeeDprt = scan.nextInt();

			if (employeeDprt == 1) {
				String insertQuery = "INSERT INTO Permanent_Employee VALUES(?,?,?,?,?)";
				st = con.prepareStatement(insertQuery);
				st.setInt(1, employeeID);
				st.setString(2, employeeName);
				st.setString(3, employeePass);
				st.setString(4, employeeSalary);
				st.setInt(5, employeeDprt);

				result = st.executeUpdate();

				if (result > 0) {
					System.out.println("query executed" + result);
				}

			} else if (employeeDprt == 2) {
				String insertQuery = "INSERT INTO PartTime_Employee VALUES(?,?,?,?,?)";
				st = con.prepareStatement(insertQuery);
				st.setInt(1, employeeID);
				st.setString(2, employeeName);
				st.setString(3, employeePass);
				st.setString(4, employeeSalary);
				st.setInt(5, employeeDprt);

				result = st.executeUpdate();

				if (result > 0) {
					System.out.println("query executed" + result);
				}
			} else if (employeeDprt == 3) {
				String insertQuery = "INSERT INTO Contract_Employee VALUES(?,?,?,?,?)";
				st = con.prepareStatement(insertQuery);
				st.setInt(1, employeeID);
				st.setString(2, employeeName);
				st.setString(3, employeePass);
				st.setString(4, employeeSalary);
				st.setInt(5, employeeDprt);

				result = st.executeUpdate();
				
				if (result > 0) {
					System.out.println("query executed" + result);
				}
			}

			System.out.println("user created");
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			scan.close();
			con.close();
			st.close();
		}

	}
}
