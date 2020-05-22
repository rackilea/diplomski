private final static String REGISTER_CONF_VAL = "/registerConfirmation";

@RequestMapping(value = "/register", method = RequestMethod.POST)
public ModelAndView createNewUser(@Valid User user, BindingResult bindingResult) {

}

// Process confirmation link
// Link in confirmation e-mail will be /registerConfirmation?token=UUID
@RequestMapping(value=REGISTER_CONF_VAL, method = RequestMethod.GET)
public ModelAndView confirmUser( @RequestParam("token") String token) {

}