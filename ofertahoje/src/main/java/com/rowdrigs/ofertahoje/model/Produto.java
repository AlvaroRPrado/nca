package com.rowdrigs.ofertahoje.model;

import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import org.hibernate.validator.constraints.NotBlank;

import com.rowdrigs.ofertahoje.validetion.SKU;


@Entity
@Table(name = "produto")
public class Produto {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long codigo;
	
	@SKU
	@NotBlank(message = "SKU é obrigatório")
	private String sku;

	@NotBlank(message = "Nome é obrigatório")
	private String nome;
	
	public String getMarca() {
		return marca;
	}

	

	@NotBlank(message = "A descrição é obrigatório")
	@Size(min = 1, max = 50, message = "O tamanho da descrição deve estar entre 1 e 50")
	private String descricao;
	
	@NotNull(message = "O valor é obrigatório")
	@DecimalMin(value = "50", message = "O valor da produto deve ser maior que R$0,50")
	@DecimalMax(value = "9999999.99", message ="O valor de produto deve ser menor que R$ 9.999.999.99")
	private BigDecimal valor;
	
	@NotNull(message = "O novo valor é obrigatório")
	@DecimalMin(value = "50", message = "O valor da produto deve ser maior que R$0,50")
	@DecimalMax(value = "9999999.99", message ="O valor de produto deve ser menor que R$ 9.999.999.99")
	private BigDecimal novovalor;

	
	@NotNull(message = "A comissão é obrigatória")
	@DecimalMax(value = "10000", message = "A comissão deve ser igual ou menor que 100")
	private BigDecimal comissao;

	@Max(value = 9999, message = "A quantidade deve ser menor que 9.999")
	@Column(name = "quantidade_estoque")
	@NotNull(message = "A quantidade de estoque é obrigatório")
	private Integer quantidadeEstoque;

	
	@Enumerated(EnumType.STRING)
	@NotNull(message = "A origem é obrigatório")
	private Origem origem;

	
	@ManyToOne
	@JoinColumn(name = "codigo_categoria")
	@NotNull(message = "O categoria é obrigatório")
	private Categoria categoria;
	
	@PrePersist @PreUpdate
	private void prePersistUpdate(){
		sku = sku.toUpperCase();
		
	}

	public String getSku() {
		return sku;
	}

	public void setSku(String sku) {
		this.sku = sku;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public void setMarca(String marca) {
		this.marca = marca;
	}

	@NotBlank(message = "Marca é obrigatório")
	private String marca;

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}


	public BigDecimal getNovovalor() {
		return novovalor;
	}

	public void setNovovalor(BigDecimal novovalor) {
		this.novovalor = novovalor;
	}

	public Integer getQuantidadeEstoque() {
		return quantidadeEstoque;
	}

	public void setQuantidadeEstoque(Integer quantidadeEstoque) {
		this.quantidadeEstoque = quantidadeEstoque;
	}

	public Origem getOrigem() {
		return origem;
	}

	public void setOrigem(Origem origem) {
		this.origem = origem;
	}


	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codigo == null) ? 0 : codigo.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Produto other = (Produto) obj;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		return true;
	}

}