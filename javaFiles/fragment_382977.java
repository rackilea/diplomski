// It will be just called when some validation or binding Exception occurs
// Otherwise, Spring will bypass it
public ModelAndView hanldeBindException(HttpServletRequest request, HttpServletResponse response, ServletRequestBindingException bindingException) {
    BindException bindException = (BindException) bindingException.getRootCause();

    BindingResult bindingResult = (BindingResult) bindException.getModel().get(BindingResult.MODEL_KEY_PREFIX + "book");

    /**
      * bindingResult.getTarget() returns submitted Book object
      */

    return new ModelAndView("bookForm")
           .addAllObjects(bindException.getModel())
           .addAttribute("bookList", bookDAO.listBooks(bindingResult.getTarget()));
}