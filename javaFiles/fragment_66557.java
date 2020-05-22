@Bean
    fun splitRouteAggregate() =
            IntegrationFlow { f ->
                f.split()
                        .route<Int, Boolean>({ o -> o % 2 == 0 },
                                { m ->
                                    m.subFlowMapping(true) { sf -> sf.gateway(oddFlow()) }
                                            .subFlowMapping(false) { sf -> sf.gateway(evenFlow()) }
                                })
                        .aggregate()
            }

    @Bean
    fun oddFlow() =
            IntegrationFlow { flow ->
                flow.handle<Any> { _, _ -> "odd" }
            }

    @Bean
    fun evenFlow() =
            IntegrationFlow { flow ->
                flow.handle<Any> { _, _ -> "even" }
            }