@Override
public void channelRead0(ChannelHandlerContext channelHandlerContext, ByteBuf in) {
    String message = in.toString(CharsetUtil.UTF_8);

    if (message.equals("10000051")) { //Now do what you were doing in channel active
        byte [] test = new byte[9];

        test[0] = 0;
        test[1] = 6;
        test[2] = 0;
        test[3] = 0;
        test[4] = 0;
        test[5] = 0;
        test[6] = 0;
        test[7] = 0;
        test[8] = 1;


        //byte [] message = "100000060".getBytes();
        channelHandlerContext.writeAndFlush(test);
    }
}