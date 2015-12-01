package jdbc.modelo;

public class Filme {
	private long ID;
	private String nomePort;
	private String nomeOrig;
	private int ano;
	private int duracao;
	private int classificacao;
	private String sinopse;
	private double somaVotos;
	private int quantidadeVotos;
	
	public long getID() {
		return ID;
	}
	public void setID(long iD) {
		ID = iD;
	}
	public String getNomePort() {
		return nomePort;
	}
	public void setNomePort(String nomePort) {
		this.nomePort = nomePort;
	}
	public String getNomeOrig() {
		return nomeOrig;
	}
	public void setNomeOrig(String nomeOrig) {
		this.nomeOrig = nomeOrig;
	}
	public int getAno() {
		return ano;
	}
	public void setAno(int ano) {
		this.ano = ano;
	}
	public int getDuracao() {
		return duracao;
	}
	public void setDuracao(int duracao) {
		this.duracao = duracao;
	}
	public int getClassificacao() {
		return classificacao;
	}
	public void setClassificacao(int classificacao) {
		this.classificacao = classificacao;
	}
	public String getSinopse() {
		return sinopse;
	}
	public void setSinopse(String sinopse) {
		this.sinopse = sinopse;
	}
	public double getSomaVotos() {
		return somaVotos;
	}
	public void setSomaVotos(double somaVotos) {
		this.somaVotos = somaVotos;
	}
	public int getQuantidadeVotos() {
		return quantidadeVotos;
	}
	public void setQuantidadeVotos(int quantidadeVotos) {
		this.quantidadeVotos = quantidadeVotos;
	}
}
