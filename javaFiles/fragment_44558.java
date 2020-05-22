class MyDecoder extends ByteToMessageDecoder {

    @Override
    protected void decode(ChannelHandlerContext ctx, ByteBuf input, List<Object> out) {
        if (input.readableBytes() < 4) {
            // we need to have at least 4 bytes to read to be able to get the message length
            return;
        }
        int length = input.getInt(input.readerIndex());
        if (input.readableBytes() < 8 + length) {
            // ensure we have enough data so we can also read the message type and the whole message body
            return;
        }
        // skip the length now
        input.skipBytes(4);

        int messageType = input.readInt();

        Supplier<AbstractMessage> supplier = SUPPLIERS.get(messageType);
        if (supplier == null) {
            LOGGER.debug("This message type isn't supported: {}", messageType);
            input.skip(length);
        } else {
            if (messageType != 6) {
                ByteBuf data = buffer.readSlice(length);
                AbstractMessage message = supplier.get();
                message.read(data, version);
                list.add(message);
                LOGGER.debug("{}", message);
            }
        }
    }
}