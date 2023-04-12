package br.edu.ifms.loja.modelo;

public class Computador {
	private Long id;
	private String marca;	
	private int memoria;
	private Double preco;
	
	public Computador() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Computador(String marca, int memoria, Double preco) {
		super();
		this.marca = marca;
		this.memoria = memoria;
		this.preco = preco;
	}
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getMarca() {
		return marca;
	}
	
	public void setMarca(String marca) {
		this.marca = marca;
	}
	
	public int getMemoria() {
		return memoria;
	}
	
	public void setMemoria(int memoria) {
		this.memoria = memoria;
	}
	
	public Double getPreco() {
		return preco;
	}
	
	public void setPreco(Double preco) {
		this.preco = preco;
	}
}
