@Bean
public IntegrationFlow findUserEnricherFlow(SystemService systemService) {
    return IntegrationFlows.from("findUserEnricherChannel")
            .enrich((enricher) -> enricher
                         .requestChannel("findUserServiceChannel")
                         .propertyExpression("email", "payload.email")
                         .propertyExpression("password", "payload.password"))

            .get();
}