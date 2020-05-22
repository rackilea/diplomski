@Override
public CompletionStage<Result> call(final Http.Context context) {
    final String token = "";

    if (StringUtils.isEmpty(token)) {
        return delegate.call(context);
    }

    return CompletableFuture.supplyAsync(() -> {
        // do something to fetch that token
        return "your_new_token";
    }).thenCompose(tokenReceived -> {
        context.args.put("user_id", tokenReceived);
        return delegate.call(context);
    });
}