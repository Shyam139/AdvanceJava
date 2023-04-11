package com.shyam.app01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class JDBCApp04 {
	public static void main(String[] args) {
		Connection con=null;
		Statement st=null;
		Scanner sc=null;
	    try {
			Class.forName("oracle.jdbc.OracleDriver");
			con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "admin");
			st= con.createStatement();
			sc=new Scanner(System.in);
			System.out.print("BONUS:");
			float bonus=sc.nextFloat();
			System.out.print("RANGE:");
			int range=sc.nextInt();
			String query="Update emp1 set esal=esal+"+bonus+" where esal<"+range;
			System.out.println(query);
			int rows=st.executeUpdate(query);
			System.out.println();
			System.out.println(rows+ " employees updated");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			
			try {
				sc.close();
				st.close();
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		
	}

}
