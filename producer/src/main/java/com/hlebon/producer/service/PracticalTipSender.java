package com.hlebon.producer.service;

import com.hlebon.common.PracticalTipMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

import static com.hlebon.producer.ProducerApplication.EXCHANGE_NAME;
import static com.hlebon.producer.ProducerApplication.ROUTING_KEY;

@Component
public class PracticalTipSender {

    private static final Logger log = LoggerFactory.getLogger(PracticalTipSender.class);

    private final RabbitTemplate rabbitTemplate;

    public PracticalTipSender(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

//    @Scheduled(fixedDelay = 5000)
    public void sendPracticalTip() {
        PracticalTipMessage tip = new PracticalTipMessage("Always use Immutable classes in Java", 1, false);
        rabbitTemplate.convertAndSend(EXCHANGE_NAME, ROUTING_KEY, tip);
        log.info("Practical Tip sent");
    }
}
