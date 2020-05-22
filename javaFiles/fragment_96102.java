/**
     * This method how to get the message history from a given channel (by default, 1000 max messages are fetched)
     */
    public void fetchSomeMessagesFromChannelHistory(SlackSession session, SlackChannel slackChannel)
    {
        //build a channelHistory module from the slack session
        ChannelHistoryModule channelHistoryModule = ChannelHistoryModuleFactory.createChannelHistoryModule(session);

        List<SlackMessagePosted> messages = channelHistoryModule.fetchHistoryOfChannel(slackChannel.getId());
}