@Component
public class CustomAuthEntryPoint implements AuthenticationEntryPoint {
  @Override
  public void commence(HttpServletRequest request, HttpServletResponse response,
      AuthenticationException exception) throws IOException, ServletException {
    System.out.println("entrypoint " + exception.getClass().getName());
    response.getOutputStream().print(exception.getClass().getName());
    response.setStatus(401);
  }
}