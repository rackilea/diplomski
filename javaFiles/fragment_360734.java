@RunAs("Employee")
@WebServlet("/myServlet")
@ServletSecurity(
  httpMethodConstraints = {
    @HttpMethodConstraint(value = "GET", rolesAllowed = "Manager"),
    @HttpMethodConstraint(value = "GET", rolesAllowed = "Employee") 
  }
)
public class MyServlet extends HttpServlet {
  // ...
}