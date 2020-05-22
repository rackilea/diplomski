@Component
public class ServiceFactory {

    @Autowired
    private List<MyService> myServices;

    public Optional<MyService> getService(MyRequest request) {

        for (MyService service: myServices) {
            if (service.canHandle(request)) {
                return Optional.of(service);
            }
        }

        return Optional.empty();
}