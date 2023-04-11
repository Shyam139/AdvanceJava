package com.shyam.app01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class JDBCApp05 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Connection con=null;
		Statement st=null;
		Scanner sc=null;
		
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "admin");
			st=con.createStatement();
			sc= new Scanner(System.in);
			System.out.print("SALARY RANGE:");
			int range=sc.nextInt();
			String query="Delete from emp1 where esal<"+ range;
			int rows=st.executeUpdate(query);
			System.out.println("Employees Deleted : "+ rows);
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
		
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
