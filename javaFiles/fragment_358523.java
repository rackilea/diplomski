private SecurityContextRepository repository = 
      new HttpSessionSecurityContextRepository();

private void login(SecurityContext securityContext, HttpServletRequest request) {
    HttpServletResponse response = new MockHttpServletResponse();

    HttpRequestResponseHolder requestResponseHolder = 
          new HttpRequestResponseHolder(request, response);
    repository.loadContext(requestResponseHolder);

    request = requestResponseHolder.getRequest();
    response = requestResponseHolder.getResponse();

    repository.saveContext(securityContext, request, response);
}