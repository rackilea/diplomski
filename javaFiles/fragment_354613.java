@Service
public class SomeHandler implements ErrorHandler {

    @Override
    public void handleError(Throwable t) {
        log.error("Error in listener", t);
    }
}