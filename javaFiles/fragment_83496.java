@Override
public void channelRead(ChannelHandlerContext ctx, Object msg) {
   final ByteBuf message = (ByteBuf) msg;
   final byte magicByte= message.getByte(0);

   if(magicByte == 0){
      new UserInfoDecoder().decode(message);
   }else if {
    ....
   }
}