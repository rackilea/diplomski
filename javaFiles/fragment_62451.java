public class AuthenticationTokenProcessingFilter extends GenericFilterBean {

AuthenticationManager authManager;

public AuthenticationTokenProcessingFilter(AuthenticationManager authManager) {
    this.authManager = authManager;
}

@Override
public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {        
    HttpServletRequest httpServletRequest = (HttpServletRequest)request;

    //access your token here and do what you wanna do with it
    String authToken = httpServletRequest.getHeader("AUTHORIZATION");

    // continue thru the filter chain
    chain.doFilter(request, response);
  }
}