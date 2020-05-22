@RequestMapping("/to-be-redirected")
public ResponseEntity<Object> redirectToExternalUrl() throws URISyntaxException {
    URI yahoo = new URI("http://www.yahoo.com");
    HttpHeaders httpHeaders = new HttpHeaders();
    httpHeaders.setLocation(yahoo);
    return new ResponseEntity<>(httpHeaders, HttpStatus.SEE_OTHER);
}