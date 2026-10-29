package com.ressurect.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class JdbcUtil {

	private JdbcUtil() {

	}

	static {
		//System.out.println("Driver class loaded");
		/**
		 * try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		 * */
	}

	// create connection object
	public static Connection getJdbcConnection() throws SQLException, IOException {

		String source = "src\\com\\ressurect\\properties\\application.properties";
		FileInputStream fis = new FileInputStream(source);
		Properties property = new Properties();
		property.load(fis);

		Connection connection = DriverManager.getConnection(property.getProperty("url"),
				property.getProperty("username"), property.getProperty("password"));
		return connection;

	}

	// close all resources
	public static void clearUpResources(Connection connection, Statement statement, ResultSet resultSet) throws SQLException {
		if(resultSet != null) {
			resultSet.close();
		}
		if(statement != null) {
			statement.close();
		}
		if(connection != null) {
			connection.close();
		}
		
	}

}
