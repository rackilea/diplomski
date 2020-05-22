@WebServlet("/processItem")
public class processItem extends HttpServlet {
private static final long serialVersionUID = 1L;

@EJB itemRegistrationRemote itemRegistrationSession;
@EJB userRegistrationRemote processRegistrationSession;
/**
 * @see HttpServlet#HttpServlet()
 */
public processItem() {
    super();
}

@Postconstruct
void init() {
  getCategories();
}...