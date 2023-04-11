package com.shyam.app01;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class JDBCApp02 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		int primKeyCount=0;
		String primKeyCol="primary key(";
		Class.forName("oracle.jdbc.OracleDriver");
		Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "admin");
		Statement st=con.createStatement();
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		System.out.print("Table Name :");
		String tName=br.readLine();
		String query="create table " +tName+"(";
		while(true) {
			System.out.print("Coloumn Name :");	
			String col=br.readLine();
			System.out.print("Datatype:");
			String dataType=br.readLine();
			System.out.print("Size:");
			String size=br.readLine();
			query=query+col+" "+ dataType+"("+size+"),";
			System.out.print("Is Primary Key(Y/N)?:");
			String primKey=br.readLine();
			if(primKey.equalsIgnoreCase("y")) {
				if(primKeyCount==0) {
					primKeyCol=primKeyCol+col;
					primKeyCount++;
				}
				else {
					primKeyCol=primKeyCol+","+col;
				}
			}

			System.out.print("More Coloumns(Y/N):");	
			String moreCol=br.readLine();
			if(moreCol.equalsIgnoreCase("y")){
				continue;
			}
			else {
				query=query+primKeyCol+"))";
				break;
			}

		}
		System.out.println(query);
		st.executeUpdate(query);
		System.out.println();
		System.out.println(tName+"table created successfully");
		st.close();
		con.close();

	}
}
