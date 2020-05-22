@WebServlet("/MyServlet")
 public class MyServlet extends HttpServlet {
    @Inject
    PersonService service;
  ....
  service.savePerson(p);
  System.out.println("Person saved");