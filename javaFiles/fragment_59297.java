// Set XML content type explicitly to force response in XML (If not spring gets response in JSON)
HttpHeaders headers = new HttpHeaders();
headers.setAccept(Arrays.asList(MediaType.APPLICATION_XML));
HttpEntity<String> entity = new HttpEntity<String>("parameters", headers);

ResponseEntity<String> response = getRestTemplate().exchange(url, HttpMethod.GET, entity, String.class);
String responseBody = response.getBody();