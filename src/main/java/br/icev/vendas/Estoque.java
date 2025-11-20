package br.icev.vendas;

import java.util.HashMap;
import java.util.Map;

import br.icev.vendas.excecoes.QuantidadeInvalidaException;
import br.icev.vendas.excecoes.SemEstoqueException;

public class Estoque {
    private final Map<String, Integer> estoque = new HashMap<>();

    public void adicionarEstoque(String codigoProduto, int quantidadeInicial) {
        if (quantidadeInicial < 0) {
            throw new QuantidadeInvalidaException("A quantidade inicial deve ser maior que 0.");
        }
        if (produto == null) {
            throw new IllegalArgumentException("O produto não pode ser nulo.");
        }
        estoque.put(codigoProduto,estoque.getOrDefault(codigoProduto, 0) + quantidadeInicial);
    }
    public int getDisponivel(String codigoProduto) {
        return estoque.getOrDefault(codigoProduto, 0);
    }

    public void reservar(String codigoProduto, int quantidade) {
        if (quantidade <= 0) {
            throw new QuantidadeInvalidaException("A quantidade a reservar deve ser positiva.");
        }

        int atual = getDisponivel(codigoProduto);

        if (atual < quantidade) {
            // Mensagem simples e direta, compatível com String
            throw new SemEstoqueException("Estoque insuficiente para o produto " + codigoProduto);
        }

        estoque.put(codigoProduto, atual - quantidade);
    }
}
