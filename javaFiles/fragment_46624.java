@ServiceActivator(inputChannel = "logging")
@Bean
public loggingHandler() {
    return new LoggingHandler();
}

...

.transform()
.wireTap("logging")
.handle();