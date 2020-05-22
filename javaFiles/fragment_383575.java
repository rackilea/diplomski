public class Widget {

    private final Service service;

    @Inject
    public Widget(Service service) {
        this.service = service;
    }
}