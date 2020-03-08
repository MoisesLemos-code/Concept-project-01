package com.moises.APIconceito.dto;

import java.io.Serializable;

import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

import com.moises.APIconceito.domain.Produto;

public class ProdutoDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Integer codigo;
	
	@NotEmpty(message = "Preenchimento obrigatório!")
	@Length(min = 5, max = 120, message = "O tamanho deve ser entre 5 e 120 caracteres!")
	private String descricao;
	private double valor;
	private double quantidade;
	
	public ProdutoDTO() {}

	public ProdutoDTO(Produto obj) {
		codigo = obj.getCodigo();
		descricao = obj.getDescricao();
		valor = obj.getValor();
		quantidade = obj.getQuantidade();
	}

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	public double getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(double quantidade) {
		this.quantidade = quantidade;
	}
	
}
