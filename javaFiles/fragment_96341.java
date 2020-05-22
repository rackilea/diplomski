@Component
public class ThreadAppRunner implements ApplicationRunner {

    @Autowired
    AsynchronousService service;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        service.executeAsynchronously()
    }

}