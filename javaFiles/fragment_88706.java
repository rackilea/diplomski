@Retryable(maxAttempts = 4,
       value = java.net.ConnectException.class,
       backoff = @Backoff(delay = 3000, multiplier = 2))
public ResponseEntity<String> getResponse(String url) {
    return webClient.get()
            .uri(url)
            .exchange()
            .flatMap(response -> response.toEntity(String.class))
            .block();
}