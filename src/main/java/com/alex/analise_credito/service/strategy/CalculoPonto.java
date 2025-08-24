package com.alex.analise_credito.service.strategy;

import com.alex.analise_credito.domain.Proposta;

public interface CalculoPonto {

    int calcular(Proposta proposta);
}
