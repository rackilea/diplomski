ClientHttpRequestFactory requestFactory = new 
HttpComponentsClientHttpRequestFactory(HttpClients.createDefault());
RestTemplate restTemplate = new RestTemplate(requestFactory);
HttpHeaders httpHeaders = new HttpHeaders();

String auth = "app" + ":" + "thisissecret";
byte[] encodedAuth = Base64.encodeBase64(auth.getBytes(Charset.forName("US-ASCII")));
httpHeaders.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
String authorisation = "Basic " + new String(encodedAuth);
httpHeaders.add("authorization", authorisation);
MultiValueMap <String, String> body = new LinkedMultiValueMap <>();
body.add("scope", "webclient");
body.add("grant_type", "password");
body.add("username", authEntity.getUsername());
body.add("password", authEntity.getPassword());

HttpEntity <MultiValueMap <String, String>> requestEntity = new HttpEntity <>(body, httpHeaders);

ResponseEntity <Token> loginResponse = null;

try {
    loginResponse = restTemplate.exchange(AUTHORIZATION_URL, HttpMethod.POST, requestEntity, Token.class);
} catch (HttpClientErrorException ex) {
    log.error("Exception: {}", ex.getLocalizedMessage());
    response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
}