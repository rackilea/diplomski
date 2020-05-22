@Bean
public IntegrationFlow udpHttpFlow() {
    return IntegrationFlows.from(udpInboundChannel())
            .transform(udpRequestTransformer())
            /* save udb request object to message header */
            .enrichHeaders(s -> s.headerExpressions(h -> h.put("udp", "payload")))
            .<UdpRequest, Boolean>route(SessionObject::sessionExists, mapping -> mapping
                    .subFlowMapping(false, sf -> sf
                            .transform(httpRequestTransformer())
                            .handle(httpOutboundGateway())
                            .transform(httpResponseTransformer())
                            /* an example how to use the udp request object */
                            .handle((payload, headers) -> headers.get("udp")))
                    .subFlowMapping(true, sf -> sf
                        /* .handle(...) */
            .transform(udpResponseTransformer())
            .handle(udpOutboundChannel())
            .get();
}