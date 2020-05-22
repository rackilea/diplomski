HttpServletResponse httpResponse = (HttpServletResponse) response;
MyHttpServletResponseWrapper wrapper = 
  new MyHttpServletResponseWrapper(httpResponse);

chain.doFilter(request, wrapper);

String content = wrapper.toString();