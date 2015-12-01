package jdbc.teste;

import java.util.List;

import jdbc.dao.PaisDao;
import jdbc.modelo.Pais;

public class TestaProcuraPaisPorNome {
	public static void main(String[] args) {
		PaisDao dao = new PaisDao();
		List<Pais> paises = dao.procuraPorNome("andia");
		
		for (Pais pais : paises) {
			System.out.println("nome:" + pais.getNome());
		}		
	}
}
