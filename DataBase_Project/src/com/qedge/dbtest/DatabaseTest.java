package com.qedge.dbtest;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;



public class DatabaseTest {

	
	public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException 
	{
	
		//Step 1: Connecting to Database
		
		//For Sql Server
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver")
														.newInstance();
		
		//For MySql
		Class.forName("com.mysql.jdbc.Driver").newInstance();
		
				
		
		Connection dbcon;		
		String dburl,uid,pwd;
		dburl="jdbc:sqlserver://primusbank.qedgetech.com:1433;" +
												"database=bankdb";
		uid="qedge";
		pwd="qedge";		
		dbcon=DriverManager.getConnection(dburl, uid, pwd);		
		//Step 2: Sending SQL Queries to DataBase
		Statement stmt=dbcon.createStatement();
		ResultSet rs=stmt.executeQuery("select count(*) from bankbranches");
		
				
		//Step 3: Processing Results
		rs.next();
		
		int brcount=rs.getInt(1);
		System.out.println(brcount);
		
		rs.close();
		dbcon.close();
		
		

	}

}
