public final class SpecificRequestService extends RequestService<JSONObject> {
    @Override
    protected Request<JSONObject> getRequest() {
        return (JsonObjectRequest) new JsonObjectRequest(...)
            {...};
    }
}