String URL="https://xyz";
RestTemplate restTemplate = new RestTemplate();

HttpHeaders headers = new HttpHeaders();

//setting up the required headers
headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
//settting user agent
headers.add("user-agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/54.0.2840.99 Safari/537.36");

headers.set("Authorization", "Bearer "+accessToken);

HttpEntity<String> entity = new HttpEntity<String>("body",headers);

//get request
ResponseEntity<String> responseEntity = restTemplate.exchange(URL, HttpMethod.GET, entity, String.class);