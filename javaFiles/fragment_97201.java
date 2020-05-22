public void onMyEvent(final SelectEvent event) {
    // Fill the bean for next view
    final RequestContext requestContext = RequestContextHolder.getRequestContext();
    requestContext.getFlowScope().put("nextBean", nextBean);
    final RequestControlContext rec = (RequestControlContext) requestContext;
    rec.handleEvent(new Event(this, "myEvent")); // the action managed by Spring Web Flow
}