@Component
public class SessionFilter extends OncePerRequestFilter {
@Override
protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
    if (!request.getRequestURI().contains("view/manager/Login") && "none".equals(Utils.SessionCheck())) {
      httpResponse.sendRedirect("view/manager/Login.jsp");
      //....
    } else {
      doFilterInternal(request, response, filterChain);
    }
}