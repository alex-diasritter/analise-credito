package com.alex.analise_credito.service.strategy.impl;
import com.alex.analise_credito.domain.Proposta;
import com.alex.analise_credito.service.strategy.CalculoPonto;
import org.springframework.stereotype.Component;

@Component
public class RendaMaiorQueOValorSolicitado  implements CalculoPonto {

    @Override
    public int calcular(Proposta proposta) {
        return rendaMaiorQueOValorSolicitado(proposta) ? 100 : 0;
    }

    private boolean rendaMaiorQueOValorSolicitado(Proposta proposta) {
        return proposta.getUsuario().getRenda() > proposta.getValorSolicitado();
    }
}
