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
            int pontos = calculoPontoList.stream().mapToInt(impl -> impl.calcular(proposta)).sum();
            proposta.setAprovado(pontos > 350);
        } catch (StrategyException strategyException) {
            proposta.setAprovado(false);
            proposta.setObs(strategyException.getMessage());
        } finally {
            rabbitMQService.notificar(exchangePropostaConcluida, proposta);
        }
    }
}
