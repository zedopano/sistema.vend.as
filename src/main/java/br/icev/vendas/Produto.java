package br.icev.vendas;

import java.math.BigDecimal;
import java.util.Objects;

public class Produto {
    private final String nome;
    private final BigDecimal precoUnitario;

    public Produto(String nome, BigDecimal precoUnitario) {
        //validação

        if (nome == null || nome.trim().isEmpty()) {
            throw new UnsupportedOperationException("nome do produto não pode ser vazio");
        }
        if (precoUnitario == null || precoUnitario.compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException("O preço unitário está vazio, presta atenção");
        }

        this.nome = nome;
        this.precoUnitario = precoUnitario;
    }

    public String getNome() {
        return nome;
    }

    public BigDecimal getPrecoUnitario() {
        return precoUnitario;
    }

    // Métodos de igualdade essenciais para POO (Equals e HashCode)
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Produto produto = (Produto) o;
        return Objects.equals(nome, produto.nome);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome);
    }
}