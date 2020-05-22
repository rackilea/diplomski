RetryTemplate template = new RetryTemplate();
Foo foo = template.execute(new RetryCallback<Foo>() {
    public Foo doWithRetry(RetryContext context) {
        /* 
         * 1. Check if RetryContext contains the token via hasAttribute. If available set the header else proceed
         * 2. Call the transmission API 
         * 3.a. If API responds with 409, read the token 
         *    3.a.1. Store the token in RetryContext via setAttribute method
         *    3.a.2. Throw a custom exception so that retry kicks in
         * 3.b. If API response is non 409 handle according to business logic
         * 4. Return result
         */
    }
});