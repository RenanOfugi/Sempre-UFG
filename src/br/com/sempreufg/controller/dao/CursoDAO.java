package br.com.sempreufg.controller.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

import br.com.sempreufg.connection.ConnectionFactory;
import br.com.sempreufg.model.Curso;

public class CursoDAO {

	private Connection connection;

	public CursoDAO() {
		this.connection = new ConnectionFactory().getConnection();
	}

	public void insert(Curso curso) throws SQLException {

		String sql = "insert into curso " + "(nome)" + " values (?)";

		try {

			PreparedStatement stmt = getConnection().prepareStatement(sql);

			stmt.setString(1, curso.getNome());

			stmt.executeUpdate();
			stmt.close();

		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			getConnection().close();
		}
	}

	public void valoresNoObjetoReg1(Curso curso, ArrayList<String> entradas) {

		curso.setNome(entradas.get(5));
	}
	
	public void valoresNoObjetoReg2(Curso curso, ArrayList<String> entradas){
		
		curso.setNome(entradas.get(3));
	}

	public Connection getConnection() {
		return connection;
	}

	public void setConnection(Connection connection) {
		this.connection = connection;
	}
}
