package foo.bar.main;

//import statements....

//this annotation will tell Spring to search for bean definitions
//in "foo.bar" package and subpackages.
@ComponentScan(basePackages = {"foo.bar"})
@SpringBootApplication
@EnableJpaAuditing
public class CrudApplication {

    public static void main(String[] args) {
        SpringApplication.run(CrudApplication.class, args);
    }
}



package foo.bar.controller;

//import statements....

//since @ComponentScan, now this bean will be discovered
@Controller
public class app {

    @GetMapping(path = "/")
    public @ResponseBody
    String hello() {
        return "Hello app";
    }
}