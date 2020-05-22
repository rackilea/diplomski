public class MyUI extends UI {

    @WebServlet(value = "/*", asyncSupported = true, initParams = {
            @WebInitParam(name = "ui", value = "com.example.MyUI"),
            @WebInitParam(name = "productionMode", value = "false") })
    public static class Servlet extends VaadinServlet {
    }

    @Override
    protected void init(VaadinRequest request) {
        ..
    }
}