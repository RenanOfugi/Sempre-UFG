package br.com.sempreufg.controller.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import br.com.sempreufg.connection.ConnectionFactory;
import br.com.sempreufg.model.Egresso;

public class EgressoDAO {

	private Connection connection;

	public EgressoDAO() {
		this.connection = new ConnectionFactory().getConnection();
	}

	public void insert(Egresso egresso) throws SQLException {

		String sql = "insert into egresso " + "(nome,tipodoc,numdoc,datanasc)" + " values (?,?,?,?)";

		try {

			PreparedStatement stmt = getConnection().prepareStatement(sql);

			stmt.setString(1, egresso.getNome());
			stmt.setString(2, egresso.getTipodoc());
			stmt.setString(3, egresso.getNumdoc());
			stmt.setString(4, egresso.getDatanasc());
			
			stmt.executeUpdate();
			stmt.close();
			
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			getConnection().close();
		}
	}

	public Connection getConnection() {
		return connection;
	}

	public void setConnection(Connection connection) {
		this.connection = connection;
	}
}
