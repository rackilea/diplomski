RestTemplate restTemplate = new RestTemplate();

HttpHeaders headers = new HttpHeaders();
headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
headers.setContentType(MediaType.APPLICATION_JSON);
headers.set("referer", "APP_1");

HttpEntity<String> entity = new HttpEntity<String>("parameters", headers);