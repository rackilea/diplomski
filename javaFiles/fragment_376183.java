public ModelAndView login(HttpServletRequest req, HttpSession session) {
    ModelAndView mav = new ModelAndView("login");
    if (session != null) {
        SavedRequest savedRequest = session.getAttribute("SPRING_SECURITY_SAVED_REQUEST");
        if (savedRequest != null) {
            mav.addObject("redirectUrl", savedRequest.getRedirectUrl());
        }
    }
    return mav;
}