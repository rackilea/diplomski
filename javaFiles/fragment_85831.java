@SpringBootApplication
@IntegrationComponentScan // finds the messaging gateway
public class So57709118Application {

    public static void main(String[] args) {
        SpringApplication.run(So57709118Application.class, args);
    }

    @Bean
    public IntegrationFlow flow() {
        return IntegrationFlows.from("gatewayChannel")
                //.route(...)
                .log()
                .nullChannel();
    }


    @Bean
    @DependsOn("flow")
    public ApplicationRunner runner(Gate gate) {
        return args -> {
            gate.method1("bar");
            gate.method2("bar");
        };
    }

}

@MessagingGateway(defaultRequestChannel = "gatewayChannel",
        defaultHeaders = @GatewayHeader(name = "method", expression = "#gatewayMethod.name"))
interface Gate {

    void method1(String foo);

    void method2(String foo);

}