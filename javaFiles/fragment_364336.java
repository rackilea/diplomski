...
} else if (request.getMethod().equals("POST")) {
    HttpHeaders headers = new HttpHeaders();
    headers.setContentType(MediaType.APPLICATION_JSON_UTF8_VALUE);
    HttpEntity<String> entity = new HttpEntity<>(body, headers);
    result = restTemplate.postForObject(newURL, entity, String.class);
}
...