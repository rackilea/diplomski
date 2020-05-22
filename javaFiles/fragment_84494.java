@Bean
public RestTemplate restTemplate(){
    RestTemplate template = new RestTemplate();

    template.getInterceptors().add(new BasicAuthInterceptor(authService));
    template.getInterceptors().add(new TokenInterceptor(authService));

    return template;
}