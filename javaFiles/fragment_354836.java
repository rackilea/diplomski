@RestController
@RequestMapping(path = "/test")
public class TestController {

    @RequestMapping(headers = "X-TEST=1")
    public void path1() {
        // Called when header "X-TEST" present and with 1
    }

    @RequestMapping(headers = "X-TEST=2")
    public void path2() {
        // Called when header "X-TEST" present and with 2
    }

    // ...
}