@Bean
public SimpleMessageListenerContainer container() {
    SimpleMessageListenerContainer smlc = new SimpleMessageListenerContainer();
    smlc.setAutoStartup(false);
    ...
    return smlc;
}