public class ServerHandler extends SimpleChannelInboundHandler<FullHttpRequest>{

    private final SampleController sc ;

    public ServerHandler(SampleController sc) {
        this.sc = sc ;
    }

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, FullHttpRequest msg) throws Exception {
        //some codes
        Model model=new Model(file.getName(),fileLength+"");
        Platform.runLater(() -> {
            sc.addModel(sendFileFeture, model);
            sc.addRowModel(sendFileFeture, rowModel);
        });
    }

}