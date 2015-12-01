package jdbc.teste;

import java.util.List;

import jdbc.dao.GeneroDao;
import jdbc.modelo.Genero;

public class TestaProcuraGeneroPorNome {
	public static void main(String[] args) {
		GeneroDao dao = new GeneroDao();
		List<Genero> generos = dao.procuraPorNome("me");
		
		for (Genero genero : generos) {
			System.out.println("nome: " + genero.getNome());
		}
	}
}
