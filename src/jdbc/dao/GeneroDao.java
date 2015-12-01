package jdbc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import jdbc.ConnectionFactory;
import jdbc.modelo.Genero;

public class GeneroDao {
	private Connection connection;

	public Connection getConnection() {
		return connection;
	}

	public void setConnection(Connection connection) {
		this.connection = connection;
	}
	
	public GeneroDao() {
		connection = new ConnectionFactory().getConnection();
	}
	
	public void adiciona(Genero genero) {
		String sql = "insert into Genero (nome) values (?)";
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setString(1,genero.getNome());
			stmt.execute();
			stmt.close();
		} catch (SQLException e){
			throw new RuntimeException(e);
		}
	}
	
	public Genero procuraPorID(long id) {
		String sql = "select * from Genero where IDGenero = ?";
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setLong(1,id);
			
			ResultSet rs = stmt.executeQuery();
			
			Genero genero = new Genero();
			
			while (rs.next()){
				genero.setID(rs.getLong("IDGenero"));
				genero.setNome(rs.getString("nome"));
			}
			
			rs.close();
			stmt.close();
			
			return genero;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public List<Genero> procuraPorNome(String nome) {
		String sql = "select * from Genero where nome like ?";
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			nome = "%" + nome + "%";
			stmt.setString(1, nome);
			
			ResultSet rs = stmt.executeQuery();
			
			List<Genero> generos = new ArrayList<Genero>();
			
			while(rs.next()){
				Genero genero = new Genero();
				genero.setID(rs.getLong("IDGenero"));
				genero.setNome(rs.getString("nome"));
				generos.add(genero);
			}
			
			rs.close();
			stmt.close();
			return generos;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
}
