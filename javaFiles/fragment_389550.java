...

@Autowired
private InboundMessagesChannelInterceptor inboundMessagesChannelInterceptor;

@Autowired
private OutboundMessagesChannelInterceptor outboundMessagesChannelInterceptor;

@Override
public void configureClientInboundChannel(ChannelRegistration registration) {
    registration.interceptors(inboundMessagesChannelInterceptor);
}

@Override
public void configureClientOutboundChannel(ChannelRegistration registration) {
    registration.interceptors(outboundMessagesChannelInterceptor);
}

...