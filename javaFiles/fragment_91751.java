public class MyService {

    private HttpServletRequest request;

    public void assertHasRequest() {
        assertNotNull(this.request);
    }

    @Value("#{request}")
    private void initialize(HttpServletRequest request) {
        System.out.println("initializing request");
        this.request = request;
    }
}