public class Control {

    private User userObj;

    @PostConstruct
    public void init() {
        userObj = new User();
    }

    // ...
}