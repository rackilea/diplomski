public class Main {
    private static class MyXmlHandler extends ChannelInboundHandlerAdapter {

        @Override
        public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
            try (InputStream in = new ByteBufInputStream((ByteBuf) msg, true)) {
                Document doc = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(in);

                // prove that we got the document
                Transformer transformer = TransformerFactory.newInstance().newTransformer();
                transformer.setOutputProperty(OutputKeys.INDENT, "yes");
                StringWriter writer = new StringWriter();
                transformer.transform(new DOMSource(doc), new StreamResult(writer));
            }
        }
    }


    public static void main(String[] args) throws InterruptedException {
        final int PORT = 8080;

        EventLoopGroup parentGroup = new NioEventLoopGroup();
        EventLoopGroup childGroup = new NioEventLoopGroup();
        try {
            ServerBootstrap server = new ServerBootstrap();
            server.group(parentGroup, childGroup).channel(NioServerSocketChannel.class)
                    .childHandler(new ChannelInitializer<SocketChannel>() {

                        @Override
                        public void initChannel(SocketChannel ch) throws Exception {
                            ch.pipeline().addLast(new XmlFrameDecoder(Integer.MAX_VALUE),
                                    new MyXmlHandler());
                        }
                    }).childOption(ChannelOption.SO_KEEPALIVE, true);

            ChannelFuture channel = server.bind(PORT).sync();
            channel.channel().closeFuture().sync();
        } finally {
            childGroup.shutdownGracefully();
            parentGroup.shutdownGracefully();
        }
    }
}