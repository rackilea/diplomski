@Bean
public MessageConverter messageConverter()
{
    ObjectMapper mapper = new ObjectMapper().findAndRegisterModules();

    return new Jackson2JsonMessageConverter(mapper);
}