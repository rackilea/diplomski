@Endpoint
public class FacadeEndpoint {
    private static final String NAMESPACE_URI = "http://my.namespace.com/services";
    @Autowired
    private RequesEndpointURLExtractor requestUrlExtractor;
    @Autowired
    private OrdersEndpoint ordersEndpoint;

    @SuppressWarnings("unchecked")
    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "execute")
    @ResponsePayload
    public ExecuteResponse dispatch(@RequestPayload Execute request) {
        String serviceURL = this.requestUrlExtractor.getCurrentURL();
        ExecuteResponse response = null;

        if (serviceURL.equals(ServiceRequestsEndpoint.CREATE_ENDPOINT_URI)) {
            Operation1DTO serviceRequest = (Operation1DTO) request.getMsg().getAnies().get(0);
}
...
}