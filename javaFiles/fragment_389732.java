@Bean
    RedisMessageListenerContainer listener(RedisConnectionFactory rcf) {
        MessageListener ml = (message, pattern) -> {
            String str = new String(message.getBody());
            log.info("message from ' " + TOPIC + "':'" + str);
        };

        RedisMessageListenerContainer mlc = new RedisMessageListenerContainer();
        mlc.setConnectionFactory(rcf);
        mlc.addMessageListener(ml, new PatternTopic(TOPIC));
        return mlc;
    }