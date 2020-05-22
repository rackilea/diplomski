TemplateRoute route = component.getDefaultHost().attach(
        "/test", new Restlet() {
    @Override
    public void handle(Request request, Response response) {
        response.setEntity("test", MediaType.TEXT_PLAIN);
    }
});

// Default matching mode
int defaultMatching = route.getMatchingMode();
// Set another matching mode
route.setMatchingMode(Template.MODE_EQUALS);