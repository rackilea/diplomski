// if the channelMappings contains a mapping, we'll use the mapped value
    // otherwise, the String-based channelKey itself will be used as the channel name
    String channelName = channelKey;
    boolean mapped = false;
    if (this.channelMappings.containsKey(channelKey)) {
        channelName = this.channelMappings.get(channelKey);
        mapped = true;
    }
    if (this.prefix != null) {
        channelName = this.prefix + channelName;
    }
    if (this.suffix != null) {
        channelName = channelName + this.suffix;
    }
    MessageChannel channel = resolveChannelForName(channelName, message);
    if (channel != null) {
        channels.add(channel);
        if (!mapped && !(this.dynamicChannels.get(channelName) != null)) {
            this.dynamicChannels.put(channelName, channel);
        }
    }