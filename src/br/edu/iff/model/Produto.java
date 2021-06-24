package br.edu.iff.model;

public class Produto {
	
    private int id;
    private int numeroPeca;
    private String tipo;
    private String modelo;
    private String material;
    private float preco;
    private int quantidade;
    
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getNumeroPeca() {
		return numeroPeca;
	}
	public void setNumeroPeca(int numeroPeca) {
		this.numeroPeca = numeroPeca;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public String getModelo() {
		return modelo;
	}
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	public String getMaterial() {
		return material;
	}
	public void setMaterial(String material) {
		this.material = material;
	}
	public float getPreco() {
		return preco;
	}
	public void setPreco(float preco) {
		this.preco = preco;
	}
	public int getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}
    
}
