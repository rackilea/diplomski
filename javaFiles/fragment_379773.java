@WebService
public class Test {

    private static final Logger LOG = Logger.getLogger(Test.class.getName());

    @Resource
    private WebServiceContext context;

    @WebMethod(operationName = "testCode")
    public String testCode(@WebParam(name = "code") int code) {
        if (code < 200 || code > 299) {
            try {
                MessageContext ctx = context.getMessageContext();
                HttpServletResponse response = (HttpServletResponse) 
                        ctx.get(MessageContext.SERVLET_RESPONSE);
                response.sendError(code, code + " You want it!");
            } catch (IOException e) {
                LOG.severe("Never happens, or yes?");
            }
        }
        return code + " Everything is fine!";
    }

}