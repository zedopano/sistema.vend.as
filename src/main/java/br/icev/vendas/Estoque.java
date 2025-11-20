package br.icev.vendas;

import java.util.HashMap;
import java.util.Map;

public class Estoque {
    private final Map<Produto, Integer> estoque = new HashMap<>();

    public void adicionarProduto(Produto produto, int quantidadeInicial) {
        if (quantidadeInicial <= 0) {
            throw new QuantidadeInvalidaException("A quantidade inicial deve ser positiva.");
        }
        if (produto == null) {
            throw new IllegalArgumentException("O produto não pode ser nulo.");
        }
        estoque.put(produto, quantidadeInicial);
    }


    public void retirar(Produto produto, int quantidade) {
        if (quantidade <= 0) {
            throw new QuantidadeInvalidaException("A quantidade a retirar deve ser positiva.");
        }

        Integer quantidadeAtual = estoque.getOrDefault(produto, 0);

        if (quantidadeAtual == 0) {
            throw new SemEstoqueException("O produto " + produto.getNome() + " não está no estoque.");
        }

        if (quantidadeAtual < quantidade) {
            throw new SemEstoqueException("Estoque insuficiente para " + produto.getNome() +
                    ". Disponível: " + quantidadeAtual + ", Solicitado: " + quantidade);
        }

        estoque.put(produto, quantidadeAtual - quantidade);
    }

    public int getQuantidade(Produto produto) {
        return estoque.getOrDefault(produto, 0);
    }
}