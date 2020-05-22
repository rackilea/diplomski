@Controller
public class MyController {

    private final MyService service;

    @Autowired
    public MyCtrl(MyService service) {
        this.service = service;
    }

    @GetMapping("/sse")
    public SseEmitter sse() {
        return service.getEmitter();
    }

    @GetMapping("/index")
    public String index() {
        return "index";
    }

    @GetMapping("/exception")
    public String exception() {
        throw new RuntimeException("Oops :o");
    }
}