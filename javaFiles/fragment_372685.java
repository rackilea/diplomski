@Bean
public IntegrationFlow routeRoundRobin() {
    return IntegrationFlows.from(getSendData())
                           .route(roundRobinRouter, "route",
                                  r -> r.channelMapping("sendDataA",
                                                        "sendDataA")
                                        .channelMapping("sendDataB",
                                                        "sendDataB"))
                           .get();
}

@Bean(name = "sendData")
public MessageChannel getSendData() {
    return MessageChannels.direct()
                          .get();
}

@Bean(name = "sendDataA")
public MessageChannel getSendDataA() {
    return MessageChannels.direct()
                          .get();
}

@Bean(name = "sendDataB")
public MessageChannel getSendDataB() {
    return MessageChannels.direct()
                          .get();
}