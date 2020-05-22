@RestController
@RequestMapping("/test")
public class TestController {   

    @GetMapping("test")
    public String withParam(TestInterfaceImpl test) {
        return "test";
    }