@RequestMapping(value = "/json", method = RequestMethod.GET, produces = "application/json")
public ResponseEntity<String> bar() {
    final HttpHeaders httpHeaders= new HttpHeaders();
    httpHeaders.setContentType(MediaType.APPLICATION_JSON);
    return new ResponseEntity<String>("{\"test\": \"jsonResponseExample\"}", httpHeaders, HttpStatus.OK);
}