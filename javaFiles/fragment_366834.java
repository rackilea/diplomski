private static final RetryTemplate retryTemplate = new RetryTemplate();
    static {
         SimpleRetryPolicy retryPolicy = new SimpleRetryPolicy();
         retryPolicy.setMaxAttempts(60);
         ExponentialBackOffPolicy backOffPolicy = new ExponentialBackOffPolicy();
         backOffPolicy.setMultiplier(2);
         backOffPolicy.setInitialInterval(10000);
         retryTemplate.setRetryPolicy(retryPolicy);
         retryTemplate.setBackOffPolicy(backOffPolicy);
    }
    private void doSomething() {
        retryTemplate.execute(retryContext -> {
            return restTemplate.postForEntity(url, request, String.class);
        });
    }