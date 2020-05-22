@RequestMapping(value = "/login", method = RequestMethod.GET)
public ModelAndView login(
    @RequestParam(value = "error", required = false) String error,
    @RequestParam(value = "logout", required = false) String logout,
    HttpServletRequest request
){
...
    CsrfToken csrfToken = (CsrfToken) request.getAttribute(CsrfToken.class.getName());
    if (csrfToken != null) {
        model.addObject("_csrf",csrfToken);
    }
...