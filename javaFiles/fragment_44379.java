@Bean
public RestTemplateBuilder restTemplateBuilder() {
    return new RestTemplateBuilder()
            .basicAuthorization("abc", "password");
}

@Bean
public RestTemplate restTemplate(RestTemplateBuilder builder) {
    return builder.build();
}