@Name("contextPath")
public class ContextPathInit implements Serializable {
    private String contextPath;

    @Observer("org.jboss.seam.postInitialization")
    public void init() {
        contextPath = ServletLifecycle.getCurrentServletContext().getContextPath();
    }
}