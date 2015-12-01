package jdbc.teste;

import jdbc.dao.FilmeDao;
import jdbc.modelo.Filme;

public class TestaInsereFilme {
	public static void main(String[] args) {
		Filme filme = new Filme();
		filme.setNomePort("Mad Max");
		filme.setNomeOrig("Mad Max");
		filme.setAno(1986);
		filme.setDuracao(120);
		filme.setClassificacao(14);
		
		FilmeDao dao = new FilmeDao();
		
		dao.adiciona(filme);
		
		System.out.print("Gravado");
	}
}
