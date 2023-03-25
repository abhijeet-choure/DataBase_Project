package com.qedge.dbtest;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;

public class Sqldbtest 
{

	private static Logger log=Logger.getLogger(Sqldbtest.class);
	
	
	public static void main(String[] args) throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
	
		DOMConfigurator.configure("log4j.xml");
		
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver")
														.newInstance();
		
		Connection dbcon;
		String url="jdbc:sqlserver://primusbank.qedgetech.com:1433;" +
													"database=bankdb";
		
		log.info("Database Connection Successful");
		
		
		
			
		String uid="qedge";
		String pwd="qedge";
		
		
		
		dbcon=DriverManager.getConnection(url, uid, pwd);
				
		
		Statement stmt=dbcon.createStatement();
	ResultSet rset=stmt.executeQuery("select branchid,branchname " +
								"from bankbranches order by branchid");
		while (rset.next()) {
			int brid=rset.getInt("branchid");
			String brname=rset.getString("branchname");
			System.out.println(brid+":"+brname);
			}
		rset.close();
		dbcon.close();	

	}

}
