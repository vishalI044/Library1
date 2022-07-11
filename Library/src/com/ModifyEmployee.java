package com;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class ModifyEmployee {
	public static void updateUser() throws SQLException, ClassNotFoundException {
		Scanner scan = new Scanner(System.in);
		Connection con = DBConnection.initialise();
		PreparedStatement st = null;
		int result;
		try {

			System.out.println("choice type 1.permanent | 2.partTime | 3.contract");
			int employeeType = scan.nextInt();

			if (employeeType == 1) {
				System.out.println("enter employeeID");
				int employeeID = scan.nextInt();

				System.out.println("enter employee name");
				String NewEmployeeName = scan.next();
				System.out.println("enter employee salary");
				String NewEmployeeSalary = scan.next();
				String QueryPer = "UPDATE Permanent_Employee SET employeeName =?, employeeSalary =? WHERE employeeID =?";
				st = con.prepareStatement(QueryPer);
				st.setString(1, NewEmployeeName);
				st.setString(2, NewEmployeeSalary);
				st.setInt(3, employeeID);
				result = st.executeUpdate();

				if (result > 0) {
					System.out.println("query executed" + result);
				}

			} else if (employeeType == 2) {
				System.out.println("enter employeeID");
				int employeeID = scan.nextInt();

				System.out.println("enter employee name");
				String NewEmployeeName = scan.next();
				System.out.println("enter employee salary");
				String NewEmployeeSalary = scan.next();
				String QueryPar = "UPDATE PartTime_Employee SET employeeName =?, employeeSalary =? WHERE employeeID =?";

				st = con.prepareStatement(QueryPar);
				st.setString(1, NewEmployeeName);
				st.setString(2, NewEmployeeSalary);
				st.setInt(3, employeeID);
				result = st.executeUpdate();

				if (result > 0) {
					System.out.println("query executed" + result);
				}
			} else if (employeeType == 3) {
				System.out.println("enter employeeID");
				int employeeID = scan.nextInt();

				System.out.println("enter employee name");
				String NewEmployeeName = scan.next();
				System.out.println("enter employee salary");
				String NewEmployeeSalary = scan.next();
				String QueryCon = "UPDATE Contract_Employee SET employeeName =?, employeeSalary =? WHERE employeeID =?";

				st = con.prepareStatement(QueryCon);
				st.setString(1, NewEmployeeName);
				st.setString(2, NewEmployeeSalary);
				st.setInt(3, employeeID);
				result = st.executeUpdate();

				if (result > 0) {
					System.out.println("query executed" + result);
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			scan.close();
			con.close();
			st.close();
			System.out.println("user modified");
		}

	}

}
