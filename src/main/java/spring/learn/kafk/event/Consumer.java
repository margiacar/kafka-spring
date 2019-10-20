package spring.learn.kafk.event;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import spring.avro.User;

@Service

public class Consumer {

	private final Logger logger = LoggerFactory.getLogger(Consumer.class);

	@KafkaListener(topics = "Multibroker-Application")//, groupId = "group_id")
	public void consume(User user) {
		logger.info(String.format("$$ -> Consumed Message -> %s", user));
	}

}