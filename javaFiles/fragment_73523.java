MockHttpServletRequest request = new MockHttpServletRequest();
     request.setServletPath("/foo/secure/super/somefile.html");

     MockHttpServletResponse response = new MockHttpServletResponse();
     MockFilterChain chain = new MockFilterChain(true);

     filterChainProxy.doFilter(request, response, chain);