public interface ControlBusGateway {

    void send(String command);
}

...

@Bean
public IntegrationFlow controlBusFlow() {
    return IntegrationFlows.from(ControlBusGateway.class)
            .controlBus()
            .get();
}