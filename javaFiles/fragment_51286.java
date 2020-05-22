MultiValueMap<String, String> headers = new LinkedMultiValueMap<>();
headers.add("X-XSRF-HEADER", "BlahBlah");
headers.add("Authorization", "Basic " + blahblah);
etc...

HttpEntity<?> request = new HttpEntity<Object>(headers);
restTemplate.exchange(url, HttpMethod.DELETE, request, String.class);