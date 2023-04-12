package br.edu.ifms.loja.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import br.edu.ifms.loja.dao.util.Conexao;
import br.edu.ifms.loja.modelo.Computador;

public class ComputadorDAO {
	private Connection connection;
	
	private void conectar() throws SQLException {
		if (connection == null || connection.isClosed()) {
			connection = Conexao.getConexao();
		}
	}

	private void desconectar() throws SQLException {
		if (connection != null && !connection.isClosed()) {
			connection.close();
		}
	}
	
	public Computador inserirComputador(Computador computador) throws SQLException {
		String sql = "INSERT INTO computador (memoria, preco, marca)"
				+ " VALUES (?, ?, ?)";
		
		conectar();

		PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
		statement.setInt(1, computador.getMemoria());
		statement.setDouble(2, computador.getPreco());
		statement.setString(3, computador.getMarca());
		
		statement.executeUpdate();
		
		ResultSet resultSet = statement.getGeneratedKeys();
		long id = 0;
		if(resultSet.next())
			id = resultSet.getInt("id");
		statement.close();

		desconectar();
		
		computador.setId(id);
		return computador;
	}
	
	public List<Computador> listarComputadores() throws SQLException {
		List<Computador> listaComputadores = new ArrayList<Computador>();
		
		String sql = "SELECT * FROM computador";
		
		conectar();
		
		Statement statement = connection.createStatement();
		ResultSet resultSet = statement.executeQuery(sql);
		
		while (resultSet.next()) {
			Long id = resultSet.getLong("id");
			int memoria = resultSet.getInt("memoria");
			Double preco = resultSet.getDouble("preco");
			String marca = resultSet.getString("marca");
			
			Computador computador = new Computador(marca, memoria, preco);
			computador.setId(id);
			
			listaComputadores.add(computador);
		}
		resultSet.close();
		statement.close();
		
		desconectar();
		
		return listaComputadores;
	}
	
}
