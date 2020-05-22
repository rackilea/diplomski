public <T, R> T yourMethodName(R requestBody, 
                               MultiValueMap<String, String> headers, 
                               String url, 
                               HttpMethod type, 
                               Class<T> clazz) {
    HttpEntity<?> request = new HttpEntity<String>(requestBody, headers);
   //You have to create restemplate Obj somewhere
    ResponseEntity<T> response = restTemplate.exchange(url, type, request, clazz);
    return response.getBody();
}