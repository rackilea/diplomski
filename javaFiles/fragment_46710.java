public class ArgsAction extends Action<Args> {

    @Override
    public Promise<Result> call(Context ctx) throws Throwable {
        final int start = configuration.start();
        final int end = configuration.end();
        if (start != -1) {
            final String path = ctx.request().path();
            String arg = null;
            if (end != -1) {
                arg = path.substring(start, end);
            } else {
                arg = path.substring(start, path.length());
            }
            // Do something with arg...
        }
        return delegate.call(ctx);
    }
}