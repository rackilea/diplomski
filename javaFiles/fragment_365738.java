@Service
@Lazy
class LazyService {

    LazyService() {
        System.out.println("service");
    }

    String bar() {
        System.out.println("bar");
        return "bar";
    }
}

@RestController
class Controller {

    private final LazyService service;

    Controller(@Lazy LazyService service) {
        this.service = service;
        System.out.println("controller");
    }

    @GetMapping("/")
    String foo() {
        System.out.println("foo");
        return service.bar();
    }
}