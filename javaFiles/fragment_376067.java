UriComponents uriComponents = UriComponentsBuilder.fromHttpUrl(uri)
  .queryParam("email","theEmail@domain.com")
  .queryParam("password","secret")
  .build();

restTemplate.getForObject(uriComponents.toUriString(), String.class);