@Override
protected Object formBackingObject(HttpServletRequest request) throws Exception {           
    if (logger.isDebugEnabled()) {
        logger.debug("In formBackingObject()... ");
        }
    Object obj = request.getSession().getAttribute(CURRENT_FORM);
    if (obj != null) {
                    }
        return obj;
    }

    MyForm Form = new MyForm(); 

    request.getSession().setAttribute(CURRENT_FORM, Form);


    return Form;
}

/**
 * Submit form
 * @param HttpServletRequest
 * @param HttpServletResponse
 * @param Object
 * @param BindException
 * @throws Exception 
 */
@Override
protected ModelAndView onSubmit(HttpServletRequest request, HttpServletResponse response, Object command, BindException errors) throws Exception {

    if (logger.isDebugEnabled()){
    logger.debug("onSubmit");
}



        ModelAndView mav;
        mav = new ModelAndView("formactivated");

        MyForm Form = (MyForm) command;


        try{                             
//do logic here

                                                    }

@Override
protected ModelAndView showForm(HttpServletRequest request, HttpServletResponse response, BindException errors)throws Exception {
    if (logger.isDebugEnabled()) {
        logger.debug("In showForm ... ");
    }

    if(errors.hasErrors()){
        if (logger.isDebugEnabled()) {
            logger.debug("In showForm  has errors... ");
        }
    ModelAndView mav;
    mav = new ModelAndView("formactivated");    
    mav.addAllObjects(errors.getModel());           
    return mav;
    }


    other login here