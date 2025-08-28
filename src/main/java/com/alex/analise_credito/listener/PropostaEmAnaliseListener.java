package com.alex.analise_credito.listener;
import com.alex.analise_credito.domain.Proposta;
import com.alex.analise_credito.service.strategy.AnaliseCreditoService;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PropostaEmAnaliseListener {

    @Autowired
    private AnaliseCreditoService service;

    @RabbitListener(queues = "${rabbitmq.queue.proposta-pendente}")
    public void propostaEmAnalise(Proposta proposta){
        service.analisar(proposta);
    }
}
