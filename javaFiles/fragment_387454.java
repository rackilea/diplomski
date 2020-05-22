import java.util.ArrayList;
import java.util.List;

import javax.jms.ConnectionFactory;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.RedeliveryPolicy;
import org.apache.activemq.broker.BrokerService;
import org.apache.activemq.broker.region.policy.DeadLetterStrategy;
import org.apache.activemq.broker.region.policy.IndividualDeadLetterStrategy;
import org.apache.activemq.broker.region.policy.PolicyEntry;
import org.apache.activemq.broker.region.policy.PolicyMap;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.stereotype.Component;

@SpringBootApplication
@Configuration
@ComponentScan(excludeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = { Configuration.class,
        Component.class }))
public class ActiveMQConfigurationDeadLetterStrategy {

    public static void main(String[] args) {
        ConfigurableApplicationContext app = SpringApplication.run(ActiveMQConfigurationDeadLetterStrategy.class, args);
    }

    @Bean
    public BrokerService broker() throws Exception {
        final BrokerService broker = new BrokerService();
        broker.addConnector("tcp://localhost:61616");
        broker.addConnector("vm://localhost");
        broker.setPersistent(false);
        broker.setDestinationPolicy(policyMap());
        return broker;
    }

    @Bean
    public PolicyMap policyMap() {
        PolicyMap destinationPolicy = new PolicyMap();
        List<PolicyEntry> entries = new ArrayList<PolicyEntry>();
        PolicyEntry queueEntry = new PolicyEntry();
        queueEntry.setQueue(">");
        queueEntry.setDeadLetterStrategy(deadLetterStrategy());
        PolicyEntry topicEntry = new PolicyEntry();
        topicEntry.setTopic(">");
        topicEntry.setDeadLetterStrategy(deadLetterStrategy());
        entries.add(queueEntry);
        entries.add(topicEntry);
        destinationPolicy.setPolicyEntries(entries);
        return destinationPolicy;
    }

    @Bean
    public DeadLetterStrategy deadLetterStrategy() {
        IndividualDeadLetterStrategy deadLetterStrategy = new IndividualDeadLetterStrategy();
        deadLetterStrategy.setQueueSuffix(".dlq");
        deadLetterStrategy.setUseQueueForQueueMessages(true);
        return deadLetterStrategy;
    }

    @Bean
    public RedeliveryPolicy redeliveryPolicy() {
        RedeliveryPolicy redeliveryPolicy = new RedeliveryPolicy();
        redeliveryPolicy.setInitialRedeliveryDelay(5000);
        redeliveryPolicy.setBackOffMultiplier(2);
        redeliveryPolicy.setUseExponentialBackOff(true);
        redeliveryPolicy.setMaximumRedeliveries(5);
        return redeliveryPolicy;
    }

    @Bean
    public ConnectionFactory jmsConnectionFactory() {
        ActiveMQConnectionFactory connectionFactory = new ActiveMQConnectionFactory();
        connectionFactory.setRedeliveryPolicy(redeliveryPolicy());
        return connectionFactory;
    }
}