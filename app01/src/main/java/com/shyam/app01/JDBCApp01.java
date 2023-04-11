package com.shyam.app01;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

class JDBCApp01{
	public static void main(String[] args) throws Throwable {
		
		//1.Load and Register Driver
		Class.forName("oracle.jdbc.OracleDriver");
		
		//2.Establish Connection
		Connection con= DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "admin");
		 
		//3.Create Statement Object
		
		Statement st= con.createStatement();
		
		//Read table name as input
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("Enter Table Name:");
		String tName=br.readLine();
		//Query String
		String query="create table "+tName+"(empno number(3) primary key, empname varchar(10), esal float(5), eaddr varchar2(10))"; 
		//4.Execute Query
		st.executeUpdate(query);
		System.out.println();
		System.out.println(tName + " created successfully..");
		
		//Close Connection
		st.close();
		con.close();
		
	}
}