@RequestMapping(path = "/path/**", consumes = "application/json")
@ResponseStatus(HttpStatus.OK)
public <T> ResponseEntity<T> getResponse(@PathVariable UUID varId, 
                                         HttpServletRequest httpServletRequest) {
   HttpMethod httpMethod = HttpMethod.valueOf(httpServletRequest.getMethod());
   if (httpMethod == httpMethod.GET) {
      //do something
   }
}