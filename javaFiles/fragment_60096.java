public interface SubListener {
    /**
     * Callback when a message is published on a subscribed channel
     * @param channel The channel the message was received on
     * @param message The received message
     */
    public void onChannelMessage(String channel, String message);

    /**
     * Callback when a message is published on a subscribed channel matching a subscribed pattern
     * @param pattern The pattern that the channel matched
     * @param channel The channel the message was received on
     * @param message The received message
     */
    public void onPatternMessage(String pattern, String channel, String message);
}