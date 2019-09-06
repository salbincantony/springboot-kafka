package com.salbin.kafka.resource;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.salbin.kafka.engine.Producer;
import com.salbin.kafka.model.User;

@RestController
@RequestMapping("kafka")
public class UserResource {

	@Autowired
	KafkaTemplate<String, User> kafkaTemplate;

	public static final String TOPIC = "kafka_example";
	
	
	private final Producer producer;

    @Autowired
    UserResource(Producer producer) {
        this.producer = producer;
    }

    @GetMapping("/publish/{message}")
    public String sendMessageToKafkaTopic(@PathVariable("message") String message) {
        this.producer.sendMessage(message);
        
        return "";
    }
	
	

	@GetMapping("/publish/{name}/{message}")
	public String post(@PathVariable("message") final String message, @PathVariable("name") final String name) {

		kafkaTemplate.send(TOPIC, new User(message, name, 30000L));

		return "Published successfully ";
	}

}
