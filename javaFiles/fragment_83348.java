HttpHeaders headers = new HttpHeaders();
headers.setContentType(MediaType.MULTIPART_FORM_DATA);

MultiValueMap<String, Object> body = new LinkedMultiValueMap<>();
body.add("file", getFileToBeUploaded());

HttpEntity<MultiValueMap<String, Object>> requestEntity = new HttpEntity<>(body, headers);

RestTemplate restTemplate = new RestTemplate();
ResponseEntity<String> response = restTemplate.postForEntity(serviveUrl, requestEntity, String.class);