class Reader extends ByteToMessageDecoder {
    @Override
    protected void decode(ChannelHandlerContext ctx, ByteBuf in, List<Object> out) throws Exception {
        byte size = in.readByte();
        if (in.readableBytes() < size) {
           in.resetReaderIndex();
           return;
        }

        ByteBuf bb = in.readSlice(size);
        //make whatever you want with bb
        Message message = ...; 
        out.add(message);
    }
}