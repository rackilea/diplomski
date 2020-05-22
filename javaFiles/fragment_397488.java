String action = "";
public void processAction(ActionRequest actionRequest, ActionResponse actionResponse)
        throws IOException, PortletException {

    if(actionRequest.getParameter("action") != null && actionRequest.getParameter("action") != ""){
            action = actionRequest.getParameter(action);
    }

    if(action.equals("shutdownReboot")){
        // shutdown-reboot logic
    }else if(action.equals("wakeup")){
        // wakeup logic
    }else{
        // default logic
    }       
}