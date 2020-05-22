ChannelFuture registerFuture;
try {
    registerFuture = castBootstrap.register().await();
} catch (InterruptedException e) {
    //Handle the exception
}

final Channel channel = registerFuture.channel();
channel.attr(MY_ATTR_KEY).set(/* some value */);

ChannelFuture connectFuture = channel.connect(/* Resolved socket address */);