services.getSomething()
  .flatMap(response -> {
    if (checkBadResponse(response)) {
      return Observable.<ResponseType>error(new RuntimeException("Error on service"));
    } else {
      return Observable.<ResponseType>just(parseResponse(response);
    }
  }).retryWhen(this::shouldRetry);