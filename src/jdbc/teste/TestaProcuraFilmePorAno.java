package jdbc.teste;

import java.sql.SQLException;
import java.util.List;

import jdbc.dao.FilmeDao;
import jdbc.modelo.Filme;

public class TestaProcuraFilmePorAno {
	public static void main(String[] args) throws SQLException {
		FilmeDao dao = new FilmeDao();
	
		List<Filme> filmes = dao.procuraPorAno(90);
	
		for (Filme filme : filmes) {
			System.out.println("NomePort: " + filme.getNomePort());
			System.out.println("NomeOrig: " + filme.getNomeOrig());
			System.out.println("ano: " + filme.getAno());
			System.out.println("duracao: " + filme.getDuracao());
			System.out.println("classificacao: " + filme.getClassificacao());
		}
	}
}
