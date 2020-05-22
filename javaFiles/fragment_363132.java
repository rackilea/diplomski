Mono.fromCallable(() -> {
        logger.debug("inside in fromCallable() block()");
        //Upstream httpcall with apache httpClient().
        // which takes atleast 1sec to complete.
        return "Http response as string";

    }).toFuture(); // this line is the blocking code.