package jdbc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import jdbc.ConnectionFactory;
import jdbc.modelo.Pais;

public class PaisDao {
	private Connection connection;
	
	public PaisDao() {
		this.setConnection(new ConnectionFactory().getConnection());
	}

	public Connection getConnection() {
		return connection;
	}

	public void setConnection(Connection connection) {
		this.connection = connection;
	}

	public void adiciona(Pais pais) {
		String sql = "insert into Pais (nome) values (?)";
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setString(1, pais.getNome());
			
			stmt.execute();
			stmt.close();
		} catch (SQLException e){
			throw new RuntimeException(e);
		}
	}
	
	public List<Pais> procuraPorNome(String nome) {
		String sql = "select * from Pais where nome like ?";
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			nome = "%"+nome+"%";
			stmt.setString(1, nome);
			
			ResultSet rs = stmt.executeQuery();
			List<Pais> paises = new ArrayList<Pais> ();
			
			while(rs.next()){
				Pais pais = new Pais();
				pais.setID(rs.getLong("IDPais"));
				pais.setNome(rs.getString("nome"));
				paises.add(pais);
			}
			
			rs.close();
			stmt.close();
			return paises;
		} catch (SQLException e){
			throw new RuntimeException(e);
		}
	}
	
	public Pais procuraPorID(long id) {
		String sql = "select * from Pais where IDPais = ?";
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setLong(1,id);
			
			ResultSet rs = stmt.executeQuery();
			Pais pais = new Pais();
			
			while(rs.next()) {
				pais.setID(rs.getLong("IDPais"));
				pais.setNome(rs.getString("nome"));
			}
			
			rs.close();
			stmt.close();
			return pais;
		} catch (SQLException e){
			throw new RuntimeException(e);
		}
	}
}
