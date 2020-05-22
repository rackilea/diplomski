public class ProjectServlet extends HttpServlet {

    @Resource UserTransaction tx;
    @EJB ProjectService bean;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        // ...
        try {
            tx.begin();
            try {
                bean.assignEmployeeToProject(projectId, empId);
                bean.updateProjectStatistics();
                EntityManagerFactory emf = Persistence.createEntityManagerFactory("myPU");
                EntityManager em = emf.createEntityManager();
                // Should be able to avoid explicit call to join transaction.
                // Should automatically join because EM created in active tx context.
                // em.joinTransaction();
                // em operations on data here
                em.close();
                emf.close();
            } finally {
                tx.commit();
            }
        } catch (Exception e) {
           // handle exceptions from UserTransaction methods
           // ...
        }
    // ...
    }
}