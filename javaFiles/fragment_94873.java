String encoding = Base64Encoder.encode("username:password");
HttpHeaders headers = new HttpHeaders();
headers.set("Authorization", "Basic " + encoding);
headers.setContentType(MediaType.APPLICATION_JSON); // optional

String data = "{ \"name\": \"TestSystem\", \"auto_init\": true, \"private\": true, \"gitignore_template\": \"nanoc\" }";
String url = "https://github.host.com/api/v3/orgs/Tester/repos";

HttpEntity<String> entity = new HttpEntity<String>(data, headers);    
RestTemplate restTemplate = new RestTemplate();
ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.POST, entity , String.class);