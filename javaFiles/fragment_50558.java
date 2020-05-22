public interface MyService {
    void sayHello();
}


public class DefaultService implements MyService {
    private static Logger log = LoggerFactory.getLogger(DefaultService.class);
    @Override
    public void sayHello() {
        log.info("Hello from DefaultService");
    }
}

public class DefaultService2 implements MyService {
    private static Logger log = LoggerFactory.getLogger(DefaultService2.class);
    @Override
    public void sayHello() {
        log.info("Hello from DefaultService2");
    }
}