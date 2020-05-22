@Override
public void initChannel(Channel channel) throws Exception {
    channel.pipeline().addLast(new HttpRequestDecoder()) // Decodes the ByteBuf into a HttpMessage and HttpContent (1)
        .addLast(new HttpObjectAggregator(1048576)) // Aggregates the HttpMessage with its following HttpContent into a FullHttpRequest
        .addLast(hostPacketHandler);
}