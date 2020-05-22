protected ModelAndView handleRequest(HttpServletRequest request,
            HttpServletResponse response, Object command, BindException errors)
            throws Exception {
        EJournalForm form = (EJournalForm) command;
        form.setUser(getUser());
        form.load(request, false);

        HttpSession session = request.getSession(false);
        session.setAttribute(LBIBOConstants.SESSION_VAR_TAB_ALERT_MSG, null);

        if(errors.hasErrors()){
            return new ModelAndView(new RedirectView(getFormView()));
        }else{
            return new ModelAndView("anotherView", "commandName", form);
        }   
    }