@RequestMapping(method = RequestMethod.GET, value = "/testValidated" , consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
public ResponseBean<String> testValidated(
        @Email(message="email RequestParam is not a valid email address") 
        @NotEmpty(message="email RequestParam is empty") 
        @RequestParam("email") String email) {
    ResponseBean<String> response = new ResponseBean<>();
    ....
    return response; 
}