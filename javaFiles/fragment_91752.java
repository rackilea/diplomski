public class MyService {

    private HttpServletRequest request;

    public void assertHasRequest() {
        assertNotNull(this.request);
    }

    @Autowired
    private void initialize(@Value("#{request}") HttpServletRequest request) {
        System.out.println("initializing request: " + request);
        this.request = request;
    }
}