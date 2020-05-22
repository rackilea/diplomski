public Promise<SimpleResult> call(Http.Context ctx) throws Throwable {

    if (authorisation token header is present in request) {
        return delegate.call(ctx);
    }

    return unauthorised();
}