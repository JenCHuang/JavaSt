package com.lcpan.m06;

import java.sql.*;
import java.io.*;

public class HWDumpData {
	private static final String DB_URL = 
			"jdbc:mysql://localhost:3306/jdbc?serverTimezone=UTC";
	private static final String USER = "root";
	private static final String PASSWORD = "mysql8251";
	
	private static final String SQL =
			"SELECT * FROM employee";
	
	private static final String FILENAME = "res/emp.dat";
	
	public static void main(String[] args) throws FileNotFoundException {
		try(	Connection conn = DriverManager.getConnection(DB_URL, USER, PASSWORD);
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(SQL);
				FileOutputStream fos = new FileOutputStream(FILENAME);
				BufferedOutputStream bos = new BufferedOutputStream(fos)){
			
			ResultSetMetaData rsmd = rs.getMetaData();
			int count = rsmd.getColumnCount(); // counting how many columns
			while(rs.next()) {
				String text = new String();
	     		for(int i = 1; i < count; i++) {
	     			text = text + rs.getString(i) + ",";
	     		}
	     		text = text + rs.getString(count) + "\n";
//	     		System.out.print(text); // print for check
	     		byte buf[] = text.getBytes();
	     		bos.write(buf);
			}
			System.out.println("Done !");
			
		}catch (SQLException e) {
			e.printStackTrace();
		}catch (IOException e) {
			e.printStackTrace();
		};
	}

}
