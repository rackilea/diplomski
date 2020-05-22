@Controller
@EnableAutoConfiguration
public class IndexController {

    @RequestMapping("/")
    @ResponseBody
    String index() {
        return “I am alive”;
    }

    // The application launcher, starts a simple controller running in the Tomcat container
    public static void main(String... args) throws Exception {
        // Start an application with your IndexController
        SpringApplication.run(IndexController.class, args);
    }
}