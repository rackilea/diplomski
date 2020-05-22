@Endpoint
public class NotifyEndPoint {

    private static final String NAMESPACE_URL = "http://fer2.klab/notify";

    @Autowired
    MainController mainController;

    @PayloadRoot(namespace = NAMESPACE_URL, localPart = "ServiceRequest")
    @Action("http://fer2.klab/notify/ServiceRequest")
//    @ResponsePayload
    public void send(@RequestPayload ServiceRequest hlMessage) {
        System.out.println("notify method");
        mainController.notify(null, "", hlMessage.getHL7Message());
    }

}