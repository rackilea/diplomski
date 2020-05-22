override fun configureClientOutboundChannel(registration: ChannelRegistration) {
    val channelInterceptor: ChannelInterceptor = object: ChannelInterceptor {
        override fun preSend(message: Message<*>, channel: MessageChannel): Message<*> {
            LOGGER.debug("Message broker sending message on Thread " + Thread.currentThread().id);
            return message
        }

        override fun postSend(message: Message<*>, channel: MessageChannel, sent: Boolean) {
            LOGGER.debug("Message broker sent message on Thread " + Thread.currentThread().id);
        }
    }
    registration.interceptors(channelInterceptor)
}