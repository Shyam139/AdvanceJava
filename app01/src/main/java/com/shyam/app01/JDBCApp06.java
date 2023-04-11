package com.shyam.app01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class JDBCApp06 {

	public static void main(String[] args) {
		Connection con=null;
		Statement st=null;
		Scanner sc= new Scanner(System.in);	
		try {
			con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "admin");
			st=con.createStatement();
			boolean b=st.execute("Update emp1 set Esal=Esal+275.0 where Esal<4000");
			int rowcount=st.getUpdateCount();
			//ResultSet rs=st.getResultSet();
			System.out.println("Execute Method for Select Query returns:"+ b);
			System.out.println("No of rows updated:"+ rowcount);
			System.out.println("EMPID\tENAME\tESAL\tEADDR");
			/*while(rs.next()) {
			
				System.out.print(rs.getInt(1)+"\t");
				System.out.print(rs.getString(2)+"\t");
				System.out.print(rs.getFloat(3)+"\t");
				System.out.print(rs.getString(4)+"\n");
				
			}*/
			
			
		}catch(Exception e) {
			e.printStackTrace();
			
		}finally {
			try {
				con.close();
			} catch (Exception e2) {
				System.out.println("Unabe to close Connection");
			}
		}

	}

}
