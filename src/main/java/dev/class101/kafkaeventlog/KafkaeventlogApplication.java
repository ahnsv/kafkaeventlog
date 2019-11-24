package dev.class101.kafkaeventlog;

import dev.class101.kafkaeventlog.engines.Consumer;
import dev.class101.kafkaeventlog.engines.Producer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.concurrent.TimeUnit;

@SpringBootApplication
public class KafkaeventlogApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(KafkaeventlogApplication.class, args);

        Producer producer = context.getBean(Producer.class);
        Consumer listener = context.getBean(Consumer.class);

        producer.sendMessage("Hello World");
        listener.listen("Hello World");

        context.close();
    }

}
