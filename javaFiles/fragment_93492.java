@Configuration
public class Config {

    @Bean
    public ActiveMQComponent activemq() {
        ActiveMQComponent comp = new ActiveMQComponent();
        comp.setBrokerUrl("tcp://localhost:61616");

        return comp;
    }
}