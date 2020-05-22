public interface MyService {

    public boolean canHandle(MyRequest request);

    // ...existing methods...
}

@Service
public class ActivateUserService extends ServiceBase {

    @Override
    public boolean canHandle(MyRequest request) {
        return Action.ACTIVATE.equals(request.getAction()) && UserType.USER.equals(request.getUserType());
    }

    // ...existing methods...
}

@Component
public class ServiceFactory {

    @Autowired
    private List<MyService> myServices;

    public Optional<MyService> getService(MyRequest request) {
        return myServices.stream()
            .filter(service -> service.canHandle(request))
            .findFirst();
    }
}