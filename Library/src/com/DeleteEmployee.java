package com;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class DeleteEmployee {
	public static void deleteUser() throws ClassNotFoundException, SQLException {
		Scanner scan = new Scanner(System.in);
		Connection con = DBConnection.initialise();
		PreparedStatement st = null;
		int result;
		try {

			System.out.println("enter employee department 1.permanent | 2.partTime | 3.contract");
			int employeeType = scan.nextInt();
			if (employeeType == 1) {
				System.out.println("enter the employee id");
				int employeeID = scan.nextInt();
				String delQuery = "DELETE FROM Permanent_Employee WHERE employeeID =?";
				st = con.prepareStatement(delQuery);
				st.setInt(1, employeeID);
				result = st.executeUpdate();

				if (result > 0) {
					System.out.println("query executed" + result);
				}
			} else if (employeeType == 2) {
				System.out.println("enter the employee id");
				int employeeID = scan.nextInt();
				String delQuery = "DELETE FROM PartTime_Employee WHERE employeeID =?";
				st = con.prepareStatement(delQuery);
				st.setInt(1, employeeID);
				result = st.executeUpdate();

				if (result > 0) {
					System.out.println("query executed" + result);
				}
			} else if (employeeType == 3) {
				System.out.println("enter the employee id");
				int employeeID = scan.nextInt();
				String delQuery = "DELETE FROM Contract_Employee WHERE employeeID =?";
				st = con.prepareStatement(delQuery);
				st.setInt(1, employeeID);
				result = st.executeUpdate();

				if (result > 0) {
					System.out.println("query executed" + result);
				}
			}
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			scan.close();
			st.close();
			con.close();
			System.out.println("user deleted");
		}
	}
}
