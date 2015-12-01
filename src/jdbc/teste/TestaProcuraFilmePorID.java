package jdbc.teste;

import java.sql.SQLException;
import jdbc.dao.FilmeDao;
import jdbc.modelo.Filme;

public class TestaProcuraFilmePorID {
	public static void main(String[] args) throws SQLException {
		FilmeDao dao = new FilmeDao();
	
		Filme filme = dao.procuraPorID(7000);
	
		System.out.println("NomePort: " + filme.getNomePort());
		System.out.println("NomeOrig: " + filme.getNomeOrig());
		System.out.println("ano: " + filme.getAno());
		System.out.println("duracao: " + filme.getDuracao());
		System.out.println("classificacao: " + filme.getClassificacao());
	}
}
