public class MyApplication extends Application {
    public MyApplication () {
        super();
    }

    @Override
    public Restlet createInboundRoot() {
        ServletContext context
          = (ServletContext) getContext().getAttributes().get(
                  "org.restlet.ext.servlet.ServletContext");
        List l = (List) context.getAttribute("myAttr");
        (...)
    }
}