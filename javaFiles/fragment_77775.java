public interface RequestTransformer {
    Request transformRequest(Request request);

    public static final RequestTransformer IDENTITY = new RequestTransformer() {
        @Override
        public Request transformRequest(Request request) {
            return request;
        }
    };
}