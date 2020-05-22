@EnableAutoConfiguration
@ComponentScan
@RestController
public class Main {

    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }

    @RequestMapping(value = "/region", method = RequestMethod.POST)
    public void region(@RequestBody Area area) {
        System.out.println("Received area: " + area);
    }
}