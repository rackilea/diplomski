Checker<A, B> checker = new Checker<A, B>() {
    @Override
    public CheckResponse<B> apply(CheckRequest<A> aCheckRequest, Function<A, B> abFunction) {
        // perform whatever operation and return a CheckResponse of type B
        return new CheckResponse<>();
    }
};