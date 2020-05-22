public class LogAction extends Action.Simple {

    @Override
    public F.Promise<Result> call(Http.Context ctx) throws Throwable {
        F.Promise<Result> call = delegate.call(ctx);
        return call.map(r -> {
            String responseBody = new String(JavaResultExtractor.getBody(r, 0L));
            Logger.info(responseBody);
            return r;
        });
    }
}