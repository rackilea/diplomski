@Override
public void initChannel(SocketChannel ch) throws Exception {
    ch.pipeline().addFirst(new LoggingHandler(LogLevel.INFO));
    ch.pipeline().addLast(new InboundHandler());
    ch.pipeline().addLast(new OutboundHandler());
}