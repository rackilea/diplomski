public class MyApplication extends Application {
    public MyApplication () {
        super();
    }

    @Override
    public Restlet createInboundRoot() {
        Series<Parameter> parameters = getContext().getParameters();
        for (Parameter parameter : parameters) {
            System.out.println("- parameter = "+parameter);
        }

        (...)
    }
}