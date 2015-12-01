package jdbc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import jdbc.ConnectionFactory;
import jdbc.modelo.Filme;

public class FilmeDao {
	private Connection connection;
	
	public FilmeDao() {
		this.setConnection(new ConnectionFactory().getConnection());
	}

	public Connection getConnection() {
		return connection;
	}

	public void setConnection(Connection connection) {
		this.connection = connection;
	}
	
	public void adiciona (Filme filme) {
		String sql = "insert into Filme (nomePort,nomeOrig,ano,duracao,classificacao) " +
					 "values (?,?,?,?,?);";
		
		try {
			// prepare statement para insercao
			java.sql.PreparedStatement stmt = connection.prepareStatement(sql);
			
			// seta os valores
			stmt.setString(1, filme.getNomePort());
			stmt.setString(2, filme.getNomeOrig());
			stmt.setInt(3, filme.getAno());
			stmt.setInt(4, filme.getDuracao());
			stmt.setInt(5, filme.getClassificacao());
			
			// executa
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	/**
	 * @param nome
	 * @return
	 * @throws SQLException
	 */
	public List<Filme> procuraPorNome (String nome) throws SQLException{
		String sql = "select * from Filme where "+
					 "nomePort LIKE ? OR nomeOrig LIKE ?;";
		PreparedStatement stmt = connection.prepareStatement(sql);
		nome = "%"+nome+"%";
		stmt.setString(1, nome);
		stmt.setString(2, nome);
		ResultSet rs = stmt.executeQuery();
		
		List<Filme> filmes = new ArrayList<Filme>();
		
		while(rs.next()){
			Filme filme = new Filme();
			filme.setID(rs.getLong("IDFilme"));
			filme.setNomeOrig(rs.getString("nomeOrig"));
			filme.setNomePort(rs.getString("nomePort"));
			filme.setAno(rs.getInt("ano"));
			filme.setDuracao(rs.getInt("duracao"));
			filme.setClassificacao(rs.getInt("classificacao"));
			filme.setSinopse(rs.getString("sinopse"));
			filme.setQuantidadeVotos(rs.getInt("quantidadeVotos"));
			filme.setSomaVotos(rs.getDouble("somaVotos"));
			
			filmes.add(filme);
		}
		
		rs.close();
		stmt.close();
		
		return filmes;
	}

	public List<Filme> procuraPorAno (int ano) throws SQLException {
		String sql = "select * from Filme where ano like ?;";
		try (PreparedStatement stmt = connection.prepareStatement(sql)) {
			stmt.setString(1, "%" + Integer.toString(ano));
			ResultSet rs = stmt.executeQuery();
		
			List<Filme> filmes = new ArrayList<Filme>();
		
			while(rs.next()){
				Filme filme = new Filme();
				filme.setID(rs.getLong("IDFilme"));
				filme.setNomeOrig(rs.getString("nomeOrig"));
				filme.setNomePort(rs.getString("nomePort"));
				filme.setAno(rs.getInt("ano"));
				filme.setDuracao(rs.getInt("duracao"));
				filme.setClassificacao(rs.getInt("classificacao"));
				filme.setSinopse(rs.getString("sinopse"));
				filme.setQuantidadeVotos(rs.getInt("quantidadeVotos"));
				filme.setSomaVotos(rs.getDouble("somaVotos"));
			
				filmes.add(filme);
			}
		
			rs.close();
			stmt.close();
		
			return filmes;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	 
	public Filme procuraPorID (long ID) {
		String sql = "select * from Filme where IDFilme = ?;";
		try ( PreparedStatement stmt = connection.prepareStatement(sql)) {
			stmt.setLong(1, ID);
			ResultSet rs = stmt.executeQuery();
			
			Filme filme = new Filme();
			
			while(rs.next()){
				filme.setID(rs.getLong("IDFilme"));
				filme.setNomeOrig(rs.getString("nomeOrig"));
				filme.setNomePort(rs.getString("nomePort"));
				filme.setAno(rs.getInt("ano"));
				filme.setDuracao(rs.getInt("duracao"));
				filme.setClassificacao(rs.getInt("classificacao"));
				filme.setSinopse(rs.getString("sinopse"));
				filme.setQuantidadeVotos(rs.getInt("quantidadeVotos"));
				filme.setSomaVotos(rs.getDouble("somaVotos"));
			}
			
			return filme;
		} catch (SQLException e){
			throw new RuntimeException(e);
		}
		
	}
}