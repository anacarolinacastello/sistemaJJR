package br.edu.iff.model;

public class Cliente extends Pessoa {
	
	private String rg;
	private int reputacao;
	
	public String getRg() {
		return rg;
	}
	public void setRg(String rg) {
		this.rg = rg;
	}
	public int getReputacao() {
		return reputacao;
	}
	public void setReputacao(int reputacao) {
		this.reputacao = reputacao;
	}
	public String toString() {
		return getId() + " " + getCpf() + " " + getNome() + " " + getDataNascimento() + " " + getTelefone() + " " + getRg() + " " + getReputacao();
		

	}
	
}
	