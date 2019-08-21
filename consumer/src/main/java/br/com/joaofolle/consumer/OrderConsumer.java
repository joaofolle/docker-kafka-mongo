package br.com.joaofolle.consumer;

import br.com.joaofolle.consumer.model.Order;

import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class OrderConsumer {
	
	Logger log = LoggerFactory.getLogger(OrderConsumer.class);

    @KafkaListener(topics = "${order.topic}", groupId = "${spring.kafka.consumer.group-id}")
    public void consumer(final ConsumerRecord<String, Order> consumerRecord) {
        log.info("key: " + consumerRecord.key());
        log.info("Headers: " + consumerRecord.headers());
        log.info("Partion: " + consumerRecord.partition());
        log.info("Order: " + consumerRecord.value());
    }
}