@Override
    @ServiceActivator(inputChannel = "input", outputChannel = "output",
            poller = @Poller(maxMessagesPerPoll = "${poller.maxMessagesPerPoll}", fixedDelay = "${poller.interval}"))
    @Publisher
    @Payload("#args[0].toLowerCase()")
    @Role("foo")
    public String handle(String payload) {
        return payload.toUpperCase();
    }