public class Server {
  public Server(int port) {
    EventLoopGroup bossGroup = new NioEventLoopGroup(1);
    EventLoopGroup workerGroup = new NioEventLoopGroup();
    try {
      ChannelFuture channelFuture = createServerBootstrap(bossGroup, workerGroup).bind(port).sync();
      channelFuture.channel().closeFuture().sync();
    } catch (InterruptedException e) {
      e.printStackTrace();
    } finally {
      bossGroup.shutdownGracefully();
      workerGroup.shutdownGracefully();
    }
  }
  private ServerBootstrap createServerBootstrap(EventLoopGroup bossGroup,
                                                EventLoopGroup workerGroup) {
    return new ServerBootstrap().group(bossGroup, workerGroup)
        .channel(NioServerSocketChannel.class)
        .handler(new LoggingHandler(LogLevel.INFO))
        .childHandler(new ChannelInitializer<SocketChannel>() {
          @Override
          protected void initChannel(SocketChannel ch) throws Exception {
             ch.pipeline().addLast(new io.netty.handler.codec.FixedLengthFrameDecoder(200));
             ch.pipeline().addLast(new ServerHandler());
          }
        });
  }
}