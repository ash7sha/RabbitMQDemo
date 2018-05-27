package com.ash7sha.RabbitMQDemo.Sender;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.ash7sha.RabbitMQDemo.model.DummyObject;

@Service
public class BasicQueueSender {
	
	@Autowired
	private AmqpTemplate rabbitTemplate;
	
	@Value("")
	private String exchange;
	
	@Value("")
	private String routingKey;
	
	public void send(DummyObject dummyObject){
		rabbitTemplate.convertAndSend(exchange, routingKey, dummyObject);
		System.out.println("Send message.." + dummyObject);
	}

}
