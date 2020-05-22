private final StringMap params;

MyLoggingMessage(final PatternLayout pattern) {
    this.pattern = pattern;
    this.params = (StringMap) ThreadContext.getContext();
}

@Override
public String getFormattedMessage() {

    LogEvent logEvent = Log4jLogEvent.newBuilder()
                                     .setContextData(params)
                                     .build();

    return pattern.toSerializable(logEvent);
}