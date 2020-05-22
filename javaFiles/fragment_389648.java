import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.GenericFilterBean;
import waffle.servlet.WindowsPrincipal;
import waffle.spring.WindowsAuthenticationToken;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;

/**
 * Handle post NTLM authentication against system database
 */
public class CustomNegotiateSecurityFilter extends GenericFilterBean {

  @Autowired
  private UserDAO userDAO;

  @Autowired
  Environment env;

  private static final Logger LOGGER = LoggerFactory.getLogger(CustomNegotiateSecurityFilter.class);

  public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {
    final HttpServletRequest request = (HttpServletRequest) req;
    final HttpServletResponse response = (HttpServletResponse) res;
    SecurityContext sec = SecurityContextHolder.getContext();
    Authentication authentication = sec.getAuthentication();

    // Continue filter chain if we are anonymously authenticated or if DB authentication has already happened.
    if (authentication != null && authentication.getClass() == WindowsAuthenticationToken.class) {

      // The user is Authenticated with NTLM but needs to be checked against the DB.
      User user;

      try {
        // fetch user from DB ...
      } catch (Exception e) {
        // The could not be found in the DB.
        sendUnauthorized(response);
        return;
      }

      // The user was found in the DB.
      WindowsPrincipal principal = (WindowsPrincipal)authentication.getPrincipal();
      final CustomAuthenticationToken token = new CustomAuthenticationToken(principal); // This class extends WindowsAuthenticationToken

      // add roles to token ...

      sec.setAuthentication(token);
    }

    chain.doFilter(request, response);
  }

  private void sendUnauthorized(HttpServletResponse response) throws IOException {
    logger.warn("Could not log in user");
    SecurityContextHolder.clearContext();
    response.sendError(HttpServletResponse.SC_UNAUTHORIZED);
  }

  private void addRoleToAuthentication(WindowsAuthenticationToken authentication, String role) {
      for(GrantedAuthority authority : authentication.getAuthorities()) {
        if(authority.getAuthority().equals(role)) {
          return;
        }
      }
      authentication.getAuthorities().add(new SimpleGrantedAuthority(role));
  }
}