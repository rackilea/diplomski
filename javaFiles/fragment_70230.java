@WebServlet(name = "indexServlet", urlPatterns = {"/indexServlet"})
public class indexServlet extends HttpServlet {

    @Inject
    LoginValidation validation;
    @PersistenceContext(unitName = "JavaEENackademinPU")
    private EntityManager em;

    //... offending line 99 calls: em.persist()
}