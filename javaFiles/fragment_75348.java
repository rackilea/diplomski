public class RestInInterceptor extends AbstractInDatabindingInterceptor {

    private static final Logger LOG = LoggerFactory
            .getLogger(RestInInterceptor.class);

    public RestInInterceptor(String phase) {
        super(Phase.USER_STREAM);
        // TODO Auto-generated constructor stub
    }

    public RestInInterceptor() {
        super(Phase.USER_STREAM);
        // TODO Auto-generated constructor stub
    }

    @Override
    public void handleMessage(Message message) throws Fault {

        Endpoint endpoint = message.getExchange().getEndpoint();

        String output = "";

        // for uri key is org.apache.cxf.request.uri
        String url = (String) message.get("org.apache.cxf.request.url");

        if(!"".equals(url) && url.contains("KP1Service")){
            Response response = Response.status(Response.Status.METHOD_NOT_ALLOWED).entity("").type(MediaType.TEXT_PLAIN) .build();
            message.getExchange().put(Response.class, response);
            return;
        }
    }
}