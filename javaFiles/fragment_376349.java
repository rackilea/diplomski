public class ServiceContextHandler implements SOAPHandler<SOAPMessageContext>{

    /**
     * Logger
     */
    private static final Logger logger = LoggerFactory.getLogger(ServiceContextHandler.class);

    /**
     * Request object
     */
    @Autowired
    private SOAPHeaderData soapHeaderData;

    /**
     * Ensure that the bean has its parameters injected appropriately
     */
    @PostConstruct
    public void init() {
        SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);
    }

    /**
     * Nothing to do on end of message
     */
    public void close(MessageContext context) {
    }


    /**
     * Nothing to do for a fault
     */
    public boolean handleFault(SOAPMessageContext context) {
        return true;
    }

    /**
     * Process the message
     */
    public boolean handleMessage(SOAPMessageContext context) {
        // no need to bother with outbound requests
        if( !((Boolean) context.get(SOAPMessageContext.MESSAGE_OUTBOUND_PROPERTY)).booleanValue() )
            process(context);
        return true;
    }

    /**
     * Doesn't handle any specific QNames in the header
     */
    public Set<QName> getHeaders() {
        return null;
    }


    /**
     * Extract the header parameters
     * @param context
     */
    @SuppressWarnings("unchecked")
    private void process(SOAPMessageContext context) {
        // Creating the XML tree
        try {
            JAXBContext jc = JAXBContext.newInstance( ObjectFactory.class);
            Object[] headers = context.getHeaders(new ObjectFactory().createServiceContext(null).getName(), jc, true);

            // find the service context element
            for( Object header : headers ){
                if( (header instanceof JAXBElement<?>) && ((JAXBElement<?>)header).getValue() instanceof ServiceContextType){
                    // found the service context element
                    soapHeaderData.setServiceContext(((JAXBElement<ServiceContextType>)header).getValue());
                    break;
                }
            }

        } catch (JAXBException e) {
            logger.error(ExceptionUtils.getStackTrace(e));
        } catch (WebServiceException e) {
            logger.error(ExceptionUtils.getStackTrace(e));
        }
    }
}