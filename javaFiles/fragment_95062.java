HttpHeaders headers = new HttpHeaders();
headers.setContentType(MediaType.APPLICATION_XML);

HttpEntity<String> entity = new HttpEntity<>("parameters", headers);

ResponseEntity<List<City>> cities = restTemplate.exchange(appPath,
           HttpMethod.GET, entity, paramType);