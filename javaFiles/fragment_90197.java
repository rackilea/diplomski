@Bean
public IntegrationFlow jmsInboundGatewayFlow() {
    return IntegrationFlows.from((MessagingGateways g) ->
            g.jms(this.jmsConnectionFactory)
                    .correlationKey("JmsCorrelationID")
                    .destination("jmsPipelineTest"))
            .<String, String>transform(String::toUpperCase)
            .get();
}