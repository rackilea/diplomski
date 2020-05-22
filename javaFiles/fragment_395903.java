HttpHeaders headers = new HttpHeaders();
headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);

MultiValueMap<String, String> map= new LinkedMultiValueMap<String, String>();
map.add("email", "first.last@example.com");

HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<MultiValueMap<String, String>>(map, headers);

ResponseEntity<String> response = restTemplate.postForEntity( url, request , String.class );