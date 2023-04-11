package com.shyam.app01;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class JDBCApp03 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Connection con=null;
		Statement st=null;
		BufferedReader br=null;
		int empId;
		String empName;
		float empSalary;
		String empAddrs;
		String progress;


		try {
			Class.forName("oracle.jdbc.OracleDriver");
			con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "admin");
			st=con.createStatement();
			System.out.println(("\t\tEnter Employee Details"));
			System.out.println("\t\t************************");

			while(true) {
				br=new BufferedReader(new InputStreamReader(System.in));
				System.out.print("Emp Id:");
				empId=Integer.parseInt(br.readLine());
				System.out.print("Emp Name:");
				empName=br.readLine();
				System.out.print("Emp Salary:");
				empSalary=Float.parseFloat(br.readLine());
				System.out.print("Emp Address:");
				empAddrs=br.readLine();
				String query= "insert into emp1 values("+empId+",'"+empName+"',"+empSalary+",'"+empAddrs+"')";
				System.out.println(query);
				int count=st.executeUpdate(query);
				if(count==1) {
					System.out.println("Employee added successfully");
				}
				
				System.out.print("Do you want to continue(Y/N):");
				progress=br.readLine();
				if(progress.equalsIgnoreCase("y")) {
					continue;
				}
				else {
					break;
				}
			}

		}


		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			try {
				br.close();
		          st.close();
		          con.close();
			}
			catch(Exception e) {
				e.printStackTrace();
			}
			finally {
			System.out.println("Connection closed");
			}
		}

	}
}
