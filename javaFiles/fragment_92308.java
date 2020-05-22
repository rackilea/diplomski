Optional<String> cookie = 
  Stream.of(headers.get(HttpHeaders.SET_COOKIE), headers.get(HttpHeaders.COOKIE))
                        .flatMap(c -> c.stream())
                        .filter(s -> s.contains("identifier"))
                        .map(c -> this.parseCookieValue(c))
                        .filter(opt -> opt.isPresent())
                        .map(opt -> opt.get())
                        .findFirst();