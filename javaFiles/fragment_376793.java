String  ip ;
int port  = 9999;

NioEventLoopGroup   workGroup = new NioEventLoopGroup(8);
NioEventLoopGroup  bossGroup = new NioEventLoopGroup();
try {
    bootstrap = new ServerBootstrap();
    bootstrap.group(bossGroup, workGroup);
    bootstrap.channel(NioServerSocketChannel.class);
    bootstrap.option(ChannelOption.SO_BACKLOG, 100);
    bootstrap.childHandler(new ChannelInitializer<SocketChannel>() {
        @Override
        protected void initChannel(SocketChannel socketChannel) throws Exception {
            socketChannel.pipeline().addLast(new StringEncoder() ,new StringDecoder() ,new LineBasedFrameDecoder(1024));
            socketChannel.pipeline().addLast(new ChannelHandlerAdapter() {
                @Override
                public void channelRegistered(ChannelHandlerContext ctx) throws Exception {
                    System.out.println("the num" +num.getAndIncrement());
                }

                @Override
                public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
                    System.out.println("what i say is :" + msg.toString());
                    ctx.channel().writeAndFlush("from server " + "reply message is " +msg.toString()+"\n");

                }
            });
        }
    });
   ChannelFuture future =  bootstrap.bind(port).sync();
    System.out.println("Server start at port : " + port);
    future.channel().closeFuture().sync();
}catch (Exception e){
    System.out.println("error");
}finally {
    bossGroup.shutdownGracefully();
    workGroup.shutdownGracefully();
}


}