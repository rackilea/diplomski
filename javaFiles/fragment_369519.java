public class ServerInitializer extends ChannelInitializer<SocketChannel> {
    @Override
    protected void initChannel(SocketChannel ch) throws Exception {
        ChannelPipeline p = ch.pipeline();

        p.addLast("encoder", new ObjectEncoder());
        p.addLast("decoder",
            new ObjectDecoder(ClassResolvers.cacheDisabled(null)));
        p.addLast("chunkedWriteHandler", new ChunkedWriteHandler());// added
        p.addLast("protocolhead", new ProtocolHeadServerHandler());
        p.addLast("filerequestserverhandler", new FileRequestServerHandler());
        // removed: p.addLast("chunkedfileserver", new ChunkedFileServerHandler());
    }
}