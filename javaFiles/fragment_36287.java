@RestController
    @RequestMapping("/test")
    public class TestController {   

        @GetMapping("test")
        public String withParam(TestInterface testInterface) {
            return "test";
        }