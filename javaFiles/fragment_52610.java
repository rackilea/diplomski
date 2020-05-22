// Prepare acceptable media type
ArrayList<MediaType> acceptableMediaTypes = new ArrayList<MediaType>();
acceptableMediaTypes.add(MediaType.APPLICATION_XML);

// Prepare header
HttpHeaders headers = new HttpHeaders();
headers.setAccept(acceptableMediaTypes);

HttpEntity<Login> entity = new HttpEntity<Login>(login, headers);
// Create status variable outside of try-catch block
HttpStatus statusCode = null;

// Send the request as POST
try {
  ResponseEntity<Login> result = restTemplate.exchange("http://www.../user/login/", 
  HttpMethod.POST, entity, Login.class);
  // Retrieve status code from ResponseEntity
  statusCode = result.getStatusCode();
} catch (Exception e) {
}
// Check if status code is OK
if (statusCode == HttpStatus.OK) {
  return "login"
}
else          
  return "redirect:/home";