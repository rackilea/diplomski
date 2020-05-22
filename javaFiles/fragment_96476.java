public class SampleFilterFunction implements HandlerFilterFunction {

    @Override
    public Mono filter(ServerRequest request, HandlerFunction next) {
        request.attributes().put("key", "value");
        return next.handle(request)
                .doOnSuccessOrError((value, error) -> request.attributes().remove("key"));
    }
}