String accessToken = OAuth2Client.generateAccessToken();
RestTemplate restTemplate = new RestTemplate();

HttpHeaders headers = new HttpHeaders();
headers.setContentType(MediaType.APPLICATION_JSON);
headers.set("Authorization", "Bearer "+accessToken);

HttpEntity<String> entity = new HttpEntity<String>(request,headers);
String response = restTemplate.postForObject(url, entity, String.class);