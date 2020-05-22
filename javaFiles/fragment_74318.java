public final class ResponseFilter implements Filter {

@Override
    public void init(FilterConfig filterConfig) {
}

@Override
public void doFilter(ServletRequest request, ServletResponse response,
                     FilterChain chain) throws IOException, ServletException {

    ResponseWrapper responseWrapper = new ResponseWrapper((HttpServletResponse) response);

    chain.doFilter(request, responseWrapper);

    String responseContent = new String(responseWrapper.getDataStream());

    RestResponse fullResponse = new RestResponse(/*status*/, /*message*/,responseContent);

    byte[] responseToSend = restResponseBytes(fullResponse);

    response.getOutputStream().write(responseToSend);

}

@Override
public void destroy() {
}

private byte[] restResponseBytes(RestResponse response) throws IOException {
    String serialized = new ObjectMapper().writeValueAsString(response);
    return serialized.getBytes();
}
}