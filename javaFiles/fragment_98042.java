public class Client {
  public Client(int port) {
    EventLoopGroup group = new NioEventLoopGroup();
    try {
      ChannelFuture channelFuture = createBootstrap(group).connect("192.168.171.102", port).sync();
      channelFuture.channel().closeFuture().sync();
    } catch (InterruptedException e) {
      e.printStackTrace();
    } finally {
      group.shutdownGracefully();
    }
  }
  private Bootstrap createBootstrap(EventLoopGroup group) {
    return new Bootstrap().group(group)
        .channel(NioSocketChannel.class)
        .option(ChannelOption.TCP_NODELAY, true)
        .handler(
            new ChannelInitializer<SocketChannel>() {
              @Override
              protected void initChannel(SocketChannel ch) throws Exception {
                ch.pipeline().addLast(new io.netty.handler.codec.FixedLengthFrameDecoder(200));
                ch.pipeline().addLast(new ClientHandler());
              }
            }
        );
  }
}