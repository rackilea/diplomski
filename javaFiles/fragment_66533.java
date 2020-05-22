Map result = x.keySet()
  .parallelStream()
  .map(req -> {
    try {
      Response response = getResponseForRequest(req);
      return new AbstractMap.SimpleEntry<>(req, response.getTitle());
    } catch (TimeoutException e) {
      return new AbstractMap.SimpleEntry<>(req, null);
    }
  })
  .collect(Collectors.toMap(AbstractMap.SimpleEntry::getKey, AbstractMap.SimpleEntry::getValue));