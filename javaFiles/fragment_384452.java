private Handler<AsyncResult<String>> handleSafely(RoutingContext ctx, String method) {
    return asyncResult -> {
        ctx.response().headers().add("content-type", "application/json");

        try {
            if (asyncResult.succeeded()) {
                ctx.response().setStatusCode(200).end(asyncResult.result());
                LOG.info("asyncResult.succeeded()", asyncResult.result());
            } else {
                LOG.error(method + " failed", asyncResult.cause().getMessage());
                ctx.response().setStatusCode(500);
                ctx.response().end(asyncResult.cause().getMessage());
            }
        } catch (Exception e) {
            LOG.error("error " + method, e);
            ctx.response().setStatusCode(500).end();
        }
    };
}