SpringBindingActionForm springBindingActionForm = (SpringBindingActionForm) form;
ServletRequestDataBinder binder = 
    new ServletRequestDataBinder(caseUpdateForm, "CaseUpdateForm");

binder.bind(request);
springBindingActionForm.expose(binder.getBindingResult(), request);