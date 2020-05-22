private final HttpComponentsClientHttpRequestFactory requestFactory = new HttpComponentsClientHttpRequestFactory(createHttpClient());

private CloseableHttpClient createHttpClient() {
    return HttpClients.custom().setRetryHandler((exception, executionCount, context) -> {
            if (executionCount > 3) {
                LOGGER.warn("Maximum tries reached for client http pool ");
                return false;
            }
            if (exception instanceof org.apache.http.NoHttpResponseException) {
                LOGGER.warn("No response from server on " + executionCount + " call");
                return true;
            }
            return false;
        }).build();
}