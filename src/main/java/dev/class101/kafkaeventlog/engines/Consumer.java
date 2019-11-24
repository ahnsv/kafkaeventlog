package dev.class101.kafkaeventlog.engines;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.util.concurrent.CountDownLatch;

@Service
public class Consumer {
    public CountDownLatch latch = new CountDownLatch(1);
    private final static Logger logger = LoggerFactory.getLogger(Consumer.class);

    @KafkaListener(topics = "${message.topic.name}", groupId = "clicklog", containerFactory = "clickLogKafkaListenerContainerFactory")
    public void listen(String message) {
        logger.info(String.format("Received Message in group 'foo': %s", message));
        latch.countDown();
    }
}
