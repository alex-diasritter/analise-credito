package com.alex.analise_credito.service.strategy.impl;

import com.alex.analise_credito.domain.Proposta;
import com.alex.analise_credito.service.strategy.CalculoPonto;
import org.springframework.stereotype.Component;

@Component
public class PrazoPagamentoInferiorDezAnos implements CalculoPonto {

    @Override
    public int calcular(Proposta proposta) {
        return proposta.getPrazoPagamento() < 120 ? 80 : 0;
    }
}
