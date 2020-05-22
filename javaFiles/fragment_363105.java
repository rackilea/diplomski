public class ProjectServlet extends HttpServlet {

    @EJB ProjectService bean;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        // ...
        try {
            EntityManagerFactory emf = Persistence.createEntityManagerFactory("myPU");
            EntityManager em = emf.createEntityManager();
            EntityTransaction tx = em.getTransaction();
            tx.begin();
            try {
                bean.assignEmployeeToProject(projectId, empId);
                bean.updateProjectStatistics();
            } finally {
                tx.commit();
            }
        } catch (Exception e) {
           // handle exceptions from EntityTransaction methods
           // ...
        }
    // ...
    }
}