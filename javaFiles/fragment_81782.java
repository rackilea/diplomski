@Bean
@BridgeTo
public MessageChannel toSftpChannel() {
    return new PublishSubscribeChannel();
}

@Bean
@ServiceActivator(inputChannel = "toSftpChannel")
@Order(0)
public MessageHandler handler() {
    SftpMessageHandler handler = new SftpMessageHandler(sftpSessionFactory());
    handler.setRemoteDirectoryExpression(new LiteralExpression("/"));
    return handler;
}