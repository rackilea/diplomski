try {
    response = restTemplate.getForEntity( ... );
    // omitted for brevity
} catch (RestClientException e) {
  if (e.getCause() instanceof ConnectException) {
    // handle connect exception 
    return ResponseEntity.status(HttpStatus.CONFLICT).body("Could not connect");
  }
  throw e; // rethrow if not a ConnectException
}