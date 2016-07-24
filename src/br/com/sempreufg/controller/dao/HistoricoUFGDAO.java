package br.com.sempreufg.controller.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import br.com.sempreufg.model.HistoricoUFG;

public class HistoricoUFGDAO {

	private Connection connection;
	
	public void insert(HistoricoUFG historico) throws SQLException {

		String sql = "insert into historicoufg " + "(dataIngresso,dataConclusao,matricula,titulo)" + " values (?,?,?,?)";

		try {

			PreparedStatement stmt = getConnection().prepareStatement(sql);

			stmt.setString(1, historico.getDataIngresso());
			stmt.setString(2, historico.getDataConclusao());
			stmt.setString(3, historico.getMatricula());
			stmt.setString(4, historico.getTitulo());
			
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
