@RestController
    @SpringBootApplication
    public class SpringBootTomcatApplication extends SpringBootServletInitializer {
    ...
      @RequestMapping(value = "/")
      public String hello() {
        return "Hello World from Tomcat";
      }
    }