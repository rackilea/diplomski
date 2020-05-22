@Path(..)
public class MyResource {
    private final MyManager manager;

    @Autowired
    public MyResource(MyManager manager) {
        this.manager = manager;
    }
}