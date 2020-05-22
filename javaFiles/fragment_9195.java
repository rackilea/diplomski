@Controller
@RequestMapping(value = "/test")
@SessionAttributes("one")
public class TestController {
    // ...

    @RequestMapping(value = "/one/two/three")
    public String dest(Model m, SessionStatus status) {
        System.out.println("one/two/three: m = " + m);
        status.setComplete();
        return "test";
    }
}