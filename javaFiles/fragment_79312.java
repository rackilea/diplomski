@ExceptionHandler(MyContextualException.class)
public void handleException(MyContextualException ex) {
    // Need access to myContext from login()
}

@RequestMapping(value = "{version}/login", method = RequestMethod.POST)
public void login(HttpServletRequest request, @PathVariable String version, @RequestParam("userName") String userName, @RequestParam("password") String password, ModelMap model) throws Exception {
    ...
    myContext = "Some contextual information"
    ...
    try {
        i_will_always_throw_an_exception();
    } catch (Exception ex) {
        throw new MyContextualException(myContext, ex);
    }
}