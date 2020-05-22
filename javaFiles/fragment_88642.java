public B execute(A req) {
    CheckRequest<A> chkReq = new CheckRequest<>();
    chkReq.setOperationRequest(req);

    Function<A, B> op;// intialised

    Checker<A, B> checker = new Checker<A, B>() {
        @Override
        public CheckResponse<B> apply(CheckRequest<A> aCheckRequest, Function<A, B> abFunction) {
            // perform whatever operation and return a CheckResponse of type B
            return new CheckResponse<>();
        }
    };

    return checker.apply(chkReq, op).getOperationResponse();
}