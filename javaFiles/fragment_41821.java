@HystrixCommand(fallbackMethod = "fallBackForProductDetail", groupKey = "CircuitBreaker", commandKey = "frontend-productdetail", threadPoolKey = "frontend-productdetail",
            commandProperties = {
                @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "3000"),//Time before which this call is supposed to complete. if not throw exception. this is Optional
                @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "5"), // Number of requests before which the cicuit is open
                @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds", value = "1200000"),//20 minutes circuit will be open
            },
            threadPoolProperties = {
                @HystrixProperty(name = "coreSize", value = "30"),
                @HystrixProperty(name = "metrics.rollingStats.timeInMilliseconds", value = "180000")// 3 minutes rolling window. i.e the errors calculated for every 3 minute window.
            })
    public String callProductDetail(.....){
         // call server1 
    }

      // Return type and arguments should be exactly same as the method for wich this is fallback. (With an optional Throwable argument to catch exception)
    public String fallBackForProductDetail(...){
        // call server2
    }