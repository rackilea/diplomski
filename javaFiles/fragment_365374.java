@Provider
HTTPRequestContextResolver implements ContextResolver<HTTPRequest> {

@Context HttpServletRequest request;

  HTTPRequest getContext(Class<?> type) {
      return new HTTPRequest(request);
  }
}