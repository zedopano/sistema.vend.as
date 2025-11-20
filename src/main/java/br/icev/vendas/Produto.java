package br.icev.vendas;

import java.math.BigDecimal;
import java.util.Objects;

public class Produto {
    private final String nome;
    private final String codigo;
    private final BigDecimal precoUnitario;

    public Produto(String nome,String codigo, BigDecimal precoUnitario) {
        //validação


        if (nome == null || nome.trim().isEmpty()) {
            throw new IllegalArgumentException("nome do produto não pode ser vazio");
        }
        if (codigo == null || codigo.trim().isEmpty()) {
            throw new IllegalArgumentException("O código do produto não pode ser vazio.");
        }
        if (precoUnitario == null || precoUnitario.compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException("O preço unitário está vazio, presta atenção");
        }
        this.codigo = codigo;
        this.nome = nome;
        this.precoUnitario = precoUnitario;
    }

    public String getNome() {
        return nome;
    }

        public String getCodigo() {
            return codigo;
        }
    public BigDecimal getPrecoUnitario() {
        return precoUnitario;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Produto produto = (Produto) o;
        return Objects.equals(codigo, produto.codigo);
    }
        @Override
        public int hashCode() {
            // Obrigatório para funcionar no HashMap do Estoque
            return Objects.hash(codigo);
        }
        @Override
        public String toString() {
            return "Produto{" +
                    "codigo='" + codigo + '\'' +
                    ", nome='" + nome + '\'' +
                    ", preco=" + precoUnitario +
                    '}';
        }
    }
