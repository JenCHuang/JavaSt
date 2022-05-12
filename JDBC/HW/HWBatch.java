package com.lcpan.m07;
import java.sql.*;
import java.io.*;

public class HWBatch {
	private static final String DB_URL = 
			"jdbc:mysql://localhost:3306/jdbc?serverTimezone=UTC";
	private static final String USER = "root";
	private static final String PASSWORD = "mysql8251";
	
	private static final String FILENAME = "res/empdata.csv";
	private static final String SQL =
			"INSERT INTO employee VALUES (?,?,?,?,?,?);";

	public static void main(String[] args) {
		try (	Connection conn = DriverManager.getConnection(DB_URL, USER, PASSWORD);
				PreparedStatement pstmt = conn.prepareStatement(SQL);
				FileInputStream fis = new FileInputStream(FILENAME);
				InputStreamReader isr = new InputStreamReader(fis,"MS950");
				BufferedReader br = new BufferedReader(isr);){
			
			String line;
    		while( (line = br.readLine()) != null ) {
//    			System.out.println(line); // Check data
    			String[] datas = line.split(",");
    			for(int i=0; i < datas.length; i++) {
    				pstmt.setString(i+1, datas[i]);
    			};
    			pstmt.addBatch();
    		}
    		pstmt.executeBatch();
    		System.out.println("Done !");
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		};
		
	}

}
