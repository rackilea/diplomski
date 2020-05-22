@Override
    public Promise<SimpleResult> call(Http.Context ctx) throws java.lang.Throwable {
        Promise<SimpleResult> result = this.delegate.call(ctx);
        Http.Response response = ctx.response();
        response.setHeader("Access-Control-Allow-Origin", "*");
        response.setContentType("application/json");
        return result;
    }