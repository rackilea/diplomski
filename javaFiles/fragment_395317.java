@Bean
public RetryTemplate retryTemplate(CustomRetryListener listener) {
    RetryTemplate retryTemplate = new RetryTemplate();
    SimpleRetryPolicy retryPolicy = new SimpleRetryPolicy();
    retryPolicy.setMaxAttempts(2);
    retryTemplate.setRetryPolicy(retryPolicy);
    retryTemplate.registerListener(listener);
    return retryTemplate;
}