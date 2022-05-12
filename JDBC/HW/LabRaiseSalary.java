package com.lcpan.m07;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LabRaiseSalary {
	private static final String DB_URL = 
			"jdbc:mysql://localhost:3306/jdbc?serverTimezone=UTC";
	private static final String USER = "root";
	private static final String PASSWORD = "mysql8251";
	
	private static final String SQL1 =
			"SELECT empno, salary FROM employee";
	private static final String SQL2 =
			"UPDATE employee SET salary = ? WHERE empno = ?";

	public static void main(String[] args) {
		Connection conn = null;
		try {
			conn = DriverManager.getConnection(DB_URL, USER, PASSWORD);

			PreparedStatement pstmt = conn.prepareStatement(SQL1);
			ResultSet rs = pstmt.executeQuery();
			pstmt = conn.prepareStatement(SQL2);
			while (rs.next()) {
				pstmt.setInt(1, rs.getInt("salary")+2000);
				pstmt.setInt(2, rs.getInt("empno"));
				pstmt.addBatch();
			}
			
			pstmt.executeBatch();
			pstmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (conn != null)
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
		}

	}

}
