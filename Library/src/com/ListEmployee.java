package com;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class ListEmployee {
	public void ListEmployee() throws ClassNotFoundException, SQLException {
		
		Scanner scan = new Scanner(System.in);
		Connection con = DBConnection.initialise();
		PreparedStatement st = null;
		try {
			System.out.println("enter employeeID");
			int employeeID = scan.nextInt();
		}catch(Exception e) {
			
		}
	}
}
