Map result = x.keySet()
  .parallelStream()
  .collect(Collectors.toMap(Function.identity(), req -> {
    try {
      Response response = getResponseForRequest(req);
      return response.getTitle()
    } catch (TimeoutException e) {
      return null
    }
  }));