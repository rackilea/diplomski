@Component
public class CustomValidatingInterceptor extends PayloadValidatingInterceptor {

    @Autowired
    private ObjectFactory<AppConfig> konfigurace;

    @Override
    public boolean handleRequest(MessageContext messageContext, Object endpoint)
            throws IOException, SAXException, TransformerException {
        System.out.println("is config aop proxy in interceptor: " +
                AopUtils.isAopProxy(konfigurace.getObject()));
        return super.handleRequest(messageContext, endpoint);
    }