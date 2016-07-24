package br.com.sempreufg.controller.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import br.com.sempreufg.connection.ConnectionFactory;
import br.com.sempreufg.model.ProgramaAcademico;

public class ProgramaAcademicoDAO {

	private Connection connection;

	public ProgramaAcademicoDAO() {
		this.setConnection(new ConnectionFactory().getConnection());
	}

	public void insert(ProgramaAcademico academico) throws SQLException {

		String sql = "insert into programaAcademico " + "(tipo,datainicio,datafim,descricao)" + " values (?,?,?,?)";

		try {

			PreparedStatement stmt = getConnection().prepareStatement(sql);

			stmt.setString(1, academico.getTipo());
			stmt.setString(2, academico.getDatainicio());
			stmt.setString(3, academico.getDatafim());
			stmt.setString(4, academico.getDescricao());

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
