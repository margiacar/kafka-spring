package spring.learn.kafk.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import spring.avro.User;
import spring.learn.kafk.event.Producer;

@RestController

@RequestMapping(value = "/kafka")

public class KafkaController {

	private final Producer producer;

	@Autowired
	public KafkaController(Producer producer) {
		this.producer = producer;
	}

	@GetMapping(value = "/send")
	public void sendMessageToKafkaTopic(@RequestParam("name") String name) {
		User user = User.newBuilder().setName(name).setFavoriteColor("green")
		        .setFavoriteNumber(null).build();
		producer.sendMessage(user);
	}	

}