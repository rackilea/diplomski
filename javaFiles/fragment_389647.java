import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.GenericFilterBean;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * This filter removes the excess negoatiate header sent by IE. If the client
 * has already authenticated, strip the Authorization header from the request.
 */
public class CustomPreAuthSecurityFilter extends GenericFilterBean {
  @Override
  public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
    SecurityContext sec = SecurityContextHolder.getContext();
    HttpServletRequest req = (HttpServletRequest) servletRequest;

    if(sec != null && sec.getAuthentication() != null) {
      req = new CustomServletRequestWrapper(req);
    }

    try {
      filterChain.doFilter(req, servletResponse);
    } catch (RuntimeException e) {
      sendUnauthorized((HttpServletResponse) servletResponse);
    }
  }

  private void sendUnauthorized(HttpServletResponse response) throws IOException {
    logger.warn("error logging in user");
    SecurityContextHolder.clearContext();
    response.sendError(HttpServletResponse.SC_UNAUTHORIZED);
  }
}