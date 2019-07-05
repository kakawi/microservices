package com.hlebon.consumer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

import static com.hlebon.consumer.ConsumerApplication.DEFAULT_PARSING_QUEUE;

@Component
public class PracticalTipListener {

    private static final Logger log = LoggerFactory.getLogger(PracticalTipListener.class);

    @RabbitListener(queues = DEFAULT_PARSING_QUEUE)
    public void consumeDefaultMessage(final Message message) {
        log.info("Received message with default conifugation: {}", message.toString());
    }
}
