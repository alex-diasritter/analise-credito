package com.alex.analise_credito.service.strategy.impl;
import com.alex.analise_credito.domain.Proposta;
import com.alex.analise_credito.exception.StrategyException;
import com.alex.analise_credito.service.strategy.CalculoPonto;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import java.util.Random;

@Order(1)
@Component
public class NomeNegativadoImpl implements CalculoPonto {


    @Override
    public int calcular(Proposta proposta) {
        if (nomeNegativado()) {
            throw new StrategyException("Nome negativado");
        }
        return 100;
    }

    private boolean nomeNegativado(){
        return new Random().nextBoolean();
    }
}
