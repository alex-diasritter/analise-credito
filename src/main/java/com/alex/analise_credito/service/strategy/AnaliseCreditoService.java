package com.alex.analise_credito.service.strategy;
import com.alex.analise_credito.domain.Proposta;
import com.alex.analise_credito.exception.StrategyException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AnaliseCreditoService {

    @Autowired
    private List<CalculoPonto> calculoPontoList;

    @Autowired
    private NotificacaoRabbitMQService rabbitMQService;

    @Value("${rabbitmq.propostaconcluida.exchange}")
    private String exchangePropostaConcluida;

    public void analisar(Proposta proposta) {
        try {
            boolean aprovada = calculoPontoList.stream()
                    .mapToInt(impl -> impl.calcular(proposta)).sum() > 350;
            proposta.setAprovada(aprovada);
        } catch (StrategyException strategyException) {
            proposta.setAprovada(false);
        }
    }
}
