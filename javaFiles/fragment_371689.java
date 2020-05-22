@RequestMapping(value = {"/login/failure"}, method = RequestMethod.GET)
public ModelAndView renderLoginFailureView(HttpServletRequest request) {
    ModelAndView mav = new ModelAndView("login");
    AuthenticationException authEx = (AuthenticationException) request.getSession().getAttribute(WebAttributes.AUTHENTICATION_EXCEPTION);

    mav.addObject("authEx", authEx.getMessage());
    return mav;
}