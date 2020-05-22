package com.test.Connector;

@Component
public class Connector {
    @Value("${connector.user}")
    private String user;

    @Value("${connector.password}")
    private String password;

    @Value("${connector.connectionAttemptDelayMillis:0}")
    private long attemptDelayMillis;

    @Scheduled(cron = "${connector.connectionAttemptCron}")
    public checkConnection() {
        // do the check
    }
}