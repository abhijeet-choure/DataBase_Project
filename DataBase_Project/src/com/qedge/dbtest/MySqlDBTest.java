package com.qedge.dbtest;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MySqlDBTest 
{

	public static void main(String[] args) throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException 
	{
	
		Class.forName("com.mysql.jdbc.Driver").newInstance();
		Connection dbcon;
		String dburl="jdbc:mysql://qedgetech.com:3306/qedge_ohrm1";
		String uid="qedgehrm";
		String pwd="12345";
		dbcon=DriverManager.getConnection(dburl, uid, pwd);
		Statement stmt=dbcon.createStatement();
		ResultSet rs=stmt.executeQuery("Select max(emp_number) " +
												"from hs_hr_employee");
		rs.next();
		int maxempid=rs.getInt(1);
		System.out.println(maxempid);
		rs.close();
		dbcon.close();
		
	}

}
