@Stateless
@LocalBean
@WebServiceProvider(serviceName = "WebserviceV2", wsdlLocation = "META-INF/wsdl/MyV2.wsdl", targetNamespace = "http://smitch.ch/service/v2", portName = "ServicePortV2")
@TransactionAttribute(TransactionAttributeType.REQUIRED)
public class ServiceImplV2 implements ServicePortV2 {

    @Inject
    private Processor processor;

    @Override
    public v2.ResponseType service(v2.RequestType soapRequest) {
       return processor.process(soapRequest);
    }