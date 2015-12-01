package jdbc.teste;

import jdbc.dao.GeneroDao;
import jdbc.modelo.Genero;

public class TestaProcuraGeneroPorID {
	public static void main(String[] args) {
		GeneroDao dao = new GeneroDao();
		Genero genero = dao.procuraPorID(2);
		
		System.out.println("nome: "+genero.getNome());
	}
}
