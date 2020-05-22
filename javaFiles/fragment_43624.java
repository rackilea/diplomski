HttpGet request = new HttpGet(URL_SECURED_BY_BASIC_AUTHENTICATION);

// Combine the user and password pair into the right format
String auth = DEFAULT_USER + ":" + DEFAULT_PASS;

// Encode the user-password pair string in Base64
byte[] encodedAuth = Base64.encodeBase64(
  auth.getBytes(StandardCharsets.ISO_8859_1));

// Build the header String "Basic [Base64 encoded String]"
String authHeader = "Basic " + new String(encodedAuth);

// Set the created header string as actual header in your request
request.setHeader(HttpHeaders.AUTHORIZATION, authHeader);

HttpClient client = HttpClientBuilder.create().build();
HttpResponse response = client.execute(request);

int statusCode = response.getStatusLine().getStatusCode();
assertThat(statusCode, equalTo(HttpStatus.SC_OK));