@RequestMapping(value = "login", method = RequestMethod.POST)
@ResponseBody
public LoginResponse login(@RequestBody SignInRequest request) throws EmailNotValidException {
    if (isValidEmailAddress(request.getEmail())) throw new EmailNotValidException();

    return response;
}