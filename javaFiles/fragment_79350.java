import org.springframework.security.web.util.UrlUtils;

public class MyAuthenticationFilter extends GenericFilterBean {
  ...
  public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        if (authentication != null) {
            String currentUrl = UrlUtils.buildRequestUrl((HttpServletRequest) request);
            Usuario usuario=(Usuario) authentication.getPrincipal();
            if("/activacion".equals(currentUrl) || "/configuracion_modelo".equals(currentUrl)) {
                chain.doFilter(request, response);
                return;
            } else if (usuario.getActivationKey()!=null) {
                ((HttpServletResponse) response).sendRedirect("/activacion");
                return;
            } else if (authentication.getAuthorities().contains(AppRole.NUEVO_USUARIO)) {
                ((HttpServletResponse)response).sendRedirect("/configuracion_modelo");
                return;
            }
        }

        chain.doFilter(request, response);
    }

    ...
}