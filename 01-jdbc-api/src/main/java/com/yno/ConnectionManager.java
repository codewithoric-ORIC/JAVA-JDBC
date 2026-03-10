package com.yno;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionManager {
	
	private static final String URL = "jdbc:mysql://localhost:3306/testDb";
	private static final String USER = "root";
	private static final String PASSWORD = "admin@123";
	
//	Multi-String
	static public Connection getConnectionWithStrings() throws SQLException {
		return DriverManager.getConnection(URL, USER, PASSWORD);
	}
	
//	SingleString
	static public Connection getConnectionWithString() throws SQLException {
		return DriverManager.getConnection(URL + "?user:= " + USER + "&password= " + PASSWORD);
	}
	
//	Connection withConnection Properties
	static public Connection geConnectionWithProperties() throws SQLException {
		Properties p = new Properties();
		p.setProperty(URL, PASSWORD);
		p.put("user", USER);
		p.put("password", PASSWORD);
		
		return DriverManager.getConnection(URL, p);
	}

}
