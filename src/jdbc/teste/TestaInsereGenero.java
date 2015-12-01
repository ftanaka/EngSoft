package jdbc.teste;

import jdbc.dao.GeneroDao;
import jdbc.modelo.Genero;

public class TestaInsereGenero {
	public static void main(String[] args) {
		Genero genero = new Genero();
		genero.setNome("Comédia");
		
		GeneroDao dao = new GeneroDao();
		dao.adiciona(genero);
		
		System.out.println("Inserido!");
	}
}
