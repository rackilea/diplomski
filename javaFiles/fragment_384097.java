public class OAuth2Action extends Action<OAuth2> {
    // ...
    @Override
    public F.Promise<SimpleResult> call(Http.Context ctx) throws Throwable {
        if (authorization  == null ) {
            return F.Promise.promise(new F.Function0<SimpleResult>() {
                @Override
                public SimpleResult apply() throws Throwable {
                    return unauthorized(ACCESS_TOKEN_NOT_FOUND);
                }
            });
        }
        return delegate.call(ctx);
    }
}