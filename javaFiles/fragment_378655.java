public class GenericExceptionHandlerFilter implements Filter {
  private final List<HttpMessageConverter<?>> converters;

  public GenericExceptionHandlerFilter(<HttpMessageConverter<?>> converters) {
    this.converters = converters;
  }

  @Override
  public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse,
      FilterChain filterChain) throws IOException {
    try {
      filterChain.doFilter(servletRequest, servletResponse);
    } catch (Exception e) {
      MyCommonResponse commonResponse = new MyCommonResponse(e);
      write(servletRequest, servletResponse, comonResponse);
      log.error("Unhandled exception.", e);
    }
  }

  private void write(HttpServletRequest servletRequest, HttpServletResponse servletResponse, Object object) throws IOException {
    String accept = servletRequest.getHeader("accept");
    for (HttpMessageConverter messageConverter : converters) {
      if (messageConverter.canWrite(object.getClass(), MediaType.valueOf(accept))) {
        HttpOutputMessage outputMessage = new ServletServerHttpResponse(servletResponse);
        messageConverter.write(object, MediaType.valueOf(accept), outputMessage);
      }
    }
  }
}