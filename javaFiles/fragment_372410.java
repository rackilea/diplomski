ActionForward originalForward = a_mapping.findForward ("Success");  
    String path = originalForward.getPath() 
        + "?multitablesId=WeeklyDeliveryInstances-Count&name=WeeklyDeliveryInstances-Count&type=excel";     

    ActionForward forward = new ActionForward(path);
    forward.setRedirect(true);
    return (forward);