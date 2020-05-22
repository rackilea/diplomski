public class BackgroundTask implements Callable<String> {

    @Inject
    EntityManager em;

    @Override
    public String call() throws Exception {
        ...
}