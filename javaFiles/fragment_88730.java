@Bean
public TcpReceivingChannelAdapter() in() {

    ...
    adapter.setOutputChannel(newRequests());

}


...

@ServiceActivator(inputChannel="toClientChannel")
@Bean
public TcpSendingMessageHandler out() {

    ...

}