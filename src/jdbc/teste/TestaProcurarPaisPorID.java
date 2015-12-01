package jdbc.teste;

import jdbc.dao.PaisDao;
import jdbc.modelo.Pais;

public class TestaProcurarPaisPorID {
	public static void main(String[] args) {
		PaisDao dao = new PaisDao();

		Pais pais = new Pais();
	
		pais = dao.procuraPorID(133);
	
		System.out.println("nome: " + pais.getNome());
	}
}
