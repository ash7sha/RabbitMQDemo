package com.ash7sha.RabbitMQDemo.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ash7sha.RabbitMQDemo.Sender.BasicQueueSender;
import com.ash7sha.RabbitMQDemo.model.DummyObject;

@RestController
@RequestMapping(value = "/rabbitmq-demo")
public class RabbitMQController {
	
	@Autowired
	BasicQueueSender basicQueueSender;
	
	@RequestMapping(value ="/producer")
	public String producer(@RequestParam("name") String name, @RequestParam("desc") String desc){
		DummyObject dummyObject = new DummyObject();
		dummyObject.setName(name);
		dummyObject.setDesc(desc);
		
		basicQueueSender.send(dummyObject);
		
		return "Message sent to Queue successfully..";
	}

}
