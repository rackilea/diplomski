@Bean
@ServiceActivator(inputChannel = "controlBusChannel")
public ExpressionControlBusFactoryBean controlBus() throws Exception {
    ExpressionControlBusFactoryBean controlBus = new ExpressionControlBusFactoryBean();
    return controlBus;
}