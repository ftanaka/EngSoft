package jdbc.teste;

import jdbc.dao.PaisDao;
import jdbc.modelo.Pais;

public class TestaInserePais {
	public static void main(String[] args) {
		PaisDao dao = new PaisDao();

		Pais pais = new Pais();
		pais.setNome("Honduras");
	
		dao.adiciona(pais);
	
		System.out.println("Adicionado");
	}
}
