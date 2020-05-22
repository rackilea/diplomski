@DeleteMapping("/api/stuff/cache")
 @CacheEvict("stuff")
 @ResponseStatus(HttpStatus.NO_CONTENT)
 public void clearCache() {

 }