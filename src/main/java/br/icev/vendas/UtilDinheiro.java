package br.icev.vendas;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.NumberFormat;
import java.util.Locale;


public class UtilDinheiro {

    private UtilDinheiro() {

    }

    public static BigDecimal calcularSubtotal(BigDecimal precoUnitario, int quantidade) {
        if (precoUnitario == null || precoUnitario.compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException("confere o preço, ta errado");
        }
        if (quantidade <= 0) {
            throw new QuantidadeInvalidaException("não tem como vender menos que 1 produto...");
        }

        return precoUnitario.multiply(BigDecimal.valueOf(quantidade)).setScale(2,RoundingMode.HALF_UP);


    }

    public static String formatarParaReal(BigDecimal valor) {
        if (valor == null) {
            return "R$ 0,00";
        }
        NumberFormat formatoReal = NumberFormat.getCurrencyInstance(new Locale("pt", "BR"));
        return formatoReal.format(valor);
    }
}