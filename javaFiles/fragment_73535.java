package com.example;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

import org.springframework.amqp.core.MessageProperties;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.amqp.rabbit.listener.adapter.MessageListenerAdapter;
import org.springframework.amqp.support.converter.ClassMapper;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.amqp.support.converter.SimpleMessageConverter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class So39264965Application {

    public static void main(String[] args) throws Exception {
        ConfigurableApplicationContext context = SpringApplication.run(So39264965Application.class, args);
        RabbitTemplate template = context.getBean(RabbitTemplate.class);
        template.convertAndSend("my.queue", new Foo());
        context.getBean(Worker.class).latch.await(60, TimeUnit.SECONDS);

        // bad json
        template.setMessageConverter(new SimpleMessageConverter());
        template.convertAndSend("", "my.queue", "\"routeId\":\"7\"}", m -> {
            m.getMessageProperties().setContentType("application/json");
            return m;
        });


        Thread.sleep(60000);
        context.close();
    }

    @Bean
    public SimpleMessageListenerContainer container(ConnectionFactory connectionFactory,
            MessageListenerAdapter listenerAdapter, MessageConverter messageConverter) {
        SimpleMessageListenerContainer container = new SimpleMessageListenerContainer();
        container.setConnectionFactory(connectionFactory);
        container.setQueueNames("my.queue");
        container.setMessageListener(listenerAdapter);
        container.setMessageConverter(messageConverter);
        return container;
    }

    @Bean
    public RabbitTemplate rabbitTemplate(ConnectionFactory connectionFactory) {
        RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
        rabbitTemplate.setMessageConverter(messageConverter());
        return rabbitTemplate;
    }

    @Bean
    public Queue queue() {
        return new Queue("my.queue");
    }

    @Bean
    public MessageConverter messageConverter() {
        Jackson2JsonMessageConverter jackson2JsonMessageConverter = new Jackson2JsonMessageConverter();
        jackson2JsonMessageConverter.setClassMapper(new ClassMapper() {

            @Override
            public Class<?> toClass(MessageProperties properties) {
                return Foo.class;
            }

            @Override
            public void fromClass(Class<?> clazz, MessageProperties properties) {

            }

        });
        return jackson2JsonMessageConverter;
    }

    @Bean
    MessageListenerAdapter listenerAdapter(Worker worker) {
        MessageListenerAdapter messageListenerAdapter = new MessageListenerAdapter(worker, "processMessage");
        messageListenerAdapter.setMessageConverter(messageConverter());
        return messageListenerAdapter;
    }

    @Bean
    public Worker worker() {
        return new Worker();
    }

    public static class Worker {

        private final CountDownLatch latch = new CountDownLatch(1);

        public void processMessage(Foo foo) {
            System.out.println(foo);
            this.latch.countDown();
        }

    }

    public static class Foo {

        private String bar = "bar";

        public String getBar() {
            return this.bar;
        }

        public void setBar(String bar) {
            this.bar = bar;
        }

        @Override
        public String toString() {
            return "Foo [bar=" + this.bar + "]";
        }

    }

}