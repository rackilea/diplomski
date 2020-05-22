public EssentialAction apply(final EssentialAction next) {
    return EssentialAction.of(request -> {
        final Accumulator<ByteString, Result> accumulator;
        final String routeComment = request.tags().get(Router.Tags.ROUTE_COMMENTS);
        if ("NOCSRF".equals(routeComment)) {
            accumulator = next.apply(request);
        } else {
            accumulator = csrfFilter.apply(next).apply(request);
        }
        return accumulator;
    });
}