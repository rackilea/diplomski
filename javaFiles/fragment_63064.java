@RequestMapping(value = "/invite", method = RequestMethod.POST)
public ModelAndView SendInvite(ModelAndView modelAndView, @RequestParam List<String> email) {
    email.stream()
        .forEach(address -> {
            User u = userService.findByEmail(address);
            if (u == null) {
                // send email here for current user;
            }
        });
    // some other stuff
}