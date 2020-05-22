private static final byte[] LENGTH_PLACEHOLDER = new byte[4];

    ChannelBufferOutputStream bout =
        new ChannelBufferOutputStream(dynamicBuffer(512, ctx.getChannel().getConfig().getBufferFactory()));
    bout.write(LENGTH_PLACEHOLDER);

    // write message contents here ...

    ChannelBuffer encoded = bout.buffer();
    encoded.setInt(0, encoded.writerIndex() - 4);
    return encoded;