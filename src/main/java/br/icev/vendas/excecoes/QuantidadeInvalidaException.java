package br.icev.vendas.excecoes;


public class QuantidadeInvalidaException extends RuntimeException {
    public QuantidadeInvalidaException(String msg) {
        super(msg);
    }
}
