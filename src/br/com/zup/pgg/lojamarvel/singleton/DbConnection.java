package br.com.zup.pgg.lojamarvel.singleton;

import java.sql.Connection;
import java.sql.DriverManager;

public class DbConnection {

	public static Connection connection = null;
	
	
	private DbConnection() {

	}
	
	public static Connection getConnection() {
		try {
			if(connection == null || connection.isClosed()) {
				
				connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/pgg?user=root&password=root");
			}
		} catch (Exception e) {
			
		}
		return connection;
		
	}
}
