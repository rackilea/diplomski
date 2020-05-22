public class UserInfoEncoder extends MessageToByteEncoder<UserInfo> {
    @Override
    protected void encode(ChannelHandlerContext ctx, UserInfo msg, ByteBuf out) {
    final int USER_BYTE = 0;
    out.writeBytes(USER_BYTE);
    out.writeBytes(msg.toBytes());
}