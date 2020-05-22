@Bean
public IntegrationFlow jmsOutboundGatewayFlow() {
    return f -> f.handleWithAdapter(a ->
            a.jmsGateway(this.jmsConnectionFactory)
//                  .replyContainer()
                    .replyDestination("pipereplies")
                    .correlationKey("JmsCorrelationID")
                    .requestDestination("jmsPipelineTest"));
}