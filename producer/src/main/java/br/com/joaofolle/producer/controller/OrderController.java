package br.com.joaofolle.producer.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.joaofolle.producer.OrderProducer;

@RestController
@RequestMapping(value = "/orders")
@Slf4j
public class OrderController {

    private final OrderProducer orderProducer;

    public OrderController(OrderProducer orderProducer) {
        this.orderProducer = orderProducer;
    }

    @RequestMapping(method = RequestMethod.POST)
    public void send(@RequestBody String order) {
        orderProducer.send(order);
    }
}
