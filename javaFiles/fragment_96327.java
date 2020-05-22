MultiValueMap<String, String> body = new LinkedMultiValueMap<String, String>();     

body.add("client_id", "fe3..b2");
// ... rest params

// Note the body object as first parameter!
HttpEntity<?> entity = new HttpEntity<Object>(body, new HttpHeaders());