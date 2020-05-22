public final class ServletManager {

    private static final Map<String, HttpServlet> servlets = new HashMap<String, HttpServlet>();

    static {
        servlets.put("controller1", new Controller1());
        servlets.put("controller2", new Controller2());
        servlets.put("controller3", new Controller3());
        // ...
    }

    public static HttpServlet get(String name) {
        return servlets.get(name);
    }

}