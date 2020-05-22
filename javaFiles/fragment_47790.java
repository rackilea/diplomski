@Configuration
@EnableIntegration
public class IntegrationConfiguration {

    @Bean
    public SimpleWebServiceInboundGateway SimpleWebServiceInboundGateway() {
            SimpleWebServiceInboundGateway simpleWebServiceInboundGateway = new SimpleWebServiceInboundGateway();
            // your inbound configurtion
            .....

            return simpleWebServiceInboundGateway;
        }

    @Bean
    public IntegrationFlow integrationFlow(){
            return IntegrationFlows.from(SimpleWebServiceInboundGateway())
            // your pipeline
            .....
                    .get();
        }   
    }