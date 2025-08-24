package com.alex.analise_credito.service.strategy;

import com.alex.analise_credito.domain.Proposta;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NotificacaoRabbitMQService {

    @Autowired
    private RabbitTemplate template;

    public void notificar(String exchange, Proposta proposta) {
        template.convertAndSend(exchange, "", proposta);
    }

}
