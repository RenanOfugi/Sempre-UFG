package br.com.sempreufg.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

	private String url;
	private String user;
	private String password;
	
	public ConnectionFactory() {
		
		setUrl("jdbc:postgresql://localhost/sempreufg");
		setUser("postgres");
		setPassword("tomodaty23");
	}
	
	public Connection getConnection(){
		
		try {
			return DriverManager.getConnection(getUrl(), getUser(), getPassword());
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
