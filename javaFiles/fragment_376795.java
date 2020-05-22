int port  = 9999;
Bootstrap bootstrap ;
NioEventLoopGroup workGroup = new NioEventLoopGroup(8);



    try {
        bootstrap = new Bootstrap();
        bootstrap.group(workGroup);
        bootstrap.channel(NioSocketChannel.class);
        bootstrap.handler(new ChannelInitializer<SocketChannel>() {
            @Override
            protected void initChannel(SocketChannel socketChannel) throws Exception {
                socketChannel.pipeline().addLast( new StringDecoder() ,new StringEncoder( )  , new LineBasedFrameDecoder(1024), new ChannelHandlerAdapter(){
                    @Override
                    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
                        System.out.println("recieve method of client : " +msg.toString());
                    }
                });
            }
        });


       NioSocketChannel nioSocketChannel ;

        ChannelFuture future = bootstrap.connect("localhost" , 9999).sync();

        //you can also invoke writeAndFlush() in other thread with channel ,
        //  it is the same as  server   
        System.out.println("try to write hello");
        Channel  channel = future.channel();
        channel.writeAndFlush("hello\n\r");


        future.channel().closeFuture().sync();   //it will block until 
                                                  //   you invoke 
                                                   //   channel.close(); 




        System.out.println("finish: " + port);

    }catch (Exception e){
        e.printStackTrace();
        System.out.println("error");
    }finally {

        workGroup.shutdownGracefully();
    }


}