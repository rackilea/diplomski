public void showById(ActionRequest actionRequest, ActionResponse actionResponse) throws IOException, PortletException {
    PortletPreferences prefs = actionRequest.getPreferences();
    String id = actionRequest.getParameter("id");

    if(id != null) {
        prefs.setValue("id", id);
        prefs.store();
    }

   String mvcPath = actionRequest.getParameter("mvcPath");

   // this would tell the render method to show the required JSP
   actionResponse.setRenderParameter("mvcPath", mvcPath); 
}