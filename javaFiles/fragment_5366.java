RestTemplate restTemplate = new RestTemplate();
HttpHeaders httpHeaders = this.createHeaders();
ResponseEntity<String> response;
response  = restTemplate.exchange(uri,HttpMethod.GET,new HttpEntity<Object>(httpHeaders),String.class);
ObjectMapper mapper = new ObjectMapper();
objectMapper.configure(DeserializationFeature.UNWRAP_ROOT_VALUE, true);
objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

PortalAccount acc = mapper.readValue(response.getBody(), PortalAccount.class);