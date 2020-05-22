@Service
public class PublishingService {

    //This bean is manually defined in application context. If spring could
    //understand how to do this from the Generic I specified below (Publisher)
    //it would be close to perfect. As I understand it, this information is
    //lost in runtime.

    @Autowired
    private ImplementationResolver<Publisher> publisherImplementationResolver;

    public void publish(PubInfo info, String message) {

        Publisher p = publisherImplementationResolver.getImplementaion(info);
        p.publish(info, message);

    }

}