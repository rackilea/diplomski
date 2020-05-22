public void doView(RenderRequest request, RenderResponse response) throws PortletException, IOException {
    String name = request.getPreferences().getValue("name", null);

    Writer writer = response.getWriter();
    writer.write("Hello, "+name+"!");
}