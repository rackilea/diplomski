@Bean
public AmqpAdmin rabbitAdmin(AbstractConnectionFactory connectionFactory) {
    RabbitAdmin admin = new RabbitAdmin(connectionFactory);
    admin.setDeclareCollections(false);
    return admin;
}