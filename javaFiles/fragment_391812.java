public void doView(
    RenderRequest renderRequest, RenderResponse renderResponse)
throws IOException, PortletException {

    PortletPreferences prefs = renderRequest.getPreferences();
    String defaultValue = "";
    // you need to recover the preference using the same name you used when you set it
    String name = prefs.getValue("Name", defaultValue);

    renderRequest.setAttribute("ATTRIBUTE_NAME", name);

    include(viewJSP, renderRequest, renderResponse);