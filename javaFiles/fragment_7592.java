@RequestMapping(value = "/login/*", method = RequestMethod.POST)
public ModelAndView handleLogin(@RequestParam("login")    String username,
                                @RequestParam("password") String password) {
    // create constructor, remove setters to make this immutable
    LoginCommand lc = new LoginCommand(username, password);
    // more code here...
}