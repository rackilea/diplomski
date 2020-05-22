private AtomicReference<ChannelMode> channelModeRef =
    new AtomicReference<ChannelMode>(
        new ChannelMode(INITIAL_CHANNEL, INITIAL_MODE));
...
Byte data[];
// get new data[]...
// atomic operation to set the new channel-mode
channelModeRef.set(new ChannelMode(data[0], data[1]);