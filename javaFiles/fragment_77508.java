ChannelBuffer frame = (ChannelBuffer) super.decode(ctx, channel, buffer);
    if (frame == null) {
        return null;
    }

    ChannelBufferInputStream data = new ChannelBufferInputStream(frame);

    // read message here ...