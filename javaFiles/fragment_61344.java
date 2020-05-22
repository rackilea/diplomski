RestTemplate restTemplate = new RestTemplate();
   MultiValueMap<String, String> body = new LinkedMultiValueMap<String, String>();
   body.add("client_id", "aViwaUZXir44tcdmr6bg7m");
   body.add("client_secret", "65d952744a49774bcf24bcd32c521619");
   body.add("grant_type", "client_credentials");
   HttpHeaders headers = new HttpHeaders();
   headers.add("Accept", "application/json");
   HttpEntity<?> entity = new HttpEntity<Object>(body, headers);
   ResponseEntity<String> res = restTemplate.exchange(
       "https://api.assembla.com/token?", HttpMethod.POST, entity, String.class);