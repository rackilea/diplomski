@RequestMapping(value="/api")
@Controller
public class TestController {
    @RequestMapping(method = RequestMethod.GET)
    public @ResponceBody String hello() {
        System.out.println("this test is done ");
        return "this is test url";
    }
}