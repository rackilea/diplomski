public final class YourContext implements AutoCloseable {

    private static ThreadLocal<YourContext> instance = new ThreadLocal<>();

    private HttpServletRequest request;
    private HttpServletResponse response;

    private YourContext(HttpServletRequest request, HttpServletResponse response) {
        this.request = request;
        this.response = response;
    }

    public static YourContext create(HttpServletRequest request, HttpServletResponse response) {
        YourContext context = new YourContext(request, response);
        instance.set(context);
        return context;
    }

    public static YourContext getCurrentInstance() {
        return instance.get();
    }

    @Override    
    public void close() {
        instance.remove();
    }

    public HttpServletRequest getRequest() {
        return request;
    }

    public HttpSession getSession() {
        return request.getSession();
    }

    public ServletContext getServletContext() {
        return request.getServletContext();
    }

    // ... (add if necessary more methods here which return/delegate the request/response).    
}