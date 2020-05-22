public class MyFilter extends Filter {
    public MyFilter() {
        super();
    }

    public MyFilter(Context context, Restlet next) {
        super(context, next);
    }

    public MyFilter(Context context) {
        super(context);
    }

    @Override
    protected int beforeHandle(Request request, Response response) {
        String ua = request.getClientInfo().getAgent();
        System.out.println("[filter] ua = " + ua);
        return Filter.CONTINUE;
    }
}