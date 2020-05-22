@Singleton
public class ContextPaths extends HashMap<String, String> {}

public class RegisterContextPath extends HttpServlet {
    @EJB
    private ContextPaths contextPaths;

    public void init() {
        String contextPath = getServletContext().getContextPath();
        contextPaths.put("myWeb1", contextPath);
    }
}