try {

result = authenticationService.getUserInfo(accessToken);

} catch (HttpClientErrorException e) {

if(e.getStatusCode().equals(HttpStatus.UNAUTHORIZED))
  //do something

String errorMsg = "Invalid access token - " + e.getMessage();

throw new InvalidAccessTokenException(errorMsg);
}