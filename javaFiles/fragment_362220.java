private HttpHeaders createHeaders(final String username, final String password ){
    HttpHeaders headers =  new HttpHeaders(){
          {
             String auth = username + ":" + password;
             byte[] encodedAuth = Base64.encodeBase64(
                auth.getBytes(Charset.forName("US-ASCII")) );
             String authHeader = "Basic " + new String( encodedAuth );
             set( "Authorization", authHeader );
          }
       };
       headers.add("Content-Type", "application/xml");
       headers.add("Accept", "application/xml");

       return headers;
}


    RestTemplate restTemplate = new RestTemplate();
    ResponseEntity<MyClass> response;
    httpHeaders = this.createHeaders("user", "pass");

    String url = "www.example.com"
    response = restTemplate.exchange(url, HttpMethod.GET, new HttpEntity<Object>(httpHeaders), MyClass.class);