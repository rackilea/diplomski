@Controller
public class FooController {
    @Autowired
    private ApplicationEventPublisher publisher;

    @GetMapping("/fireEvent")
    public void fireEvent() {
        publisher.publishEvent(new FooEvent(this));
    }
}