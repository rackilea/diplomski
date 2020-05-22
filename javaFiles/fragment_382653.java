@RestController
@SpringBootApplication
public class TestOptionApplication {

    public static void main(String[] args) {
        SpringApplication.run(TestOptionApplication.class, args);
    }

    @PostMapping("/test")
    public void formTest(@RequestBody final HelloForm form) {
    }

    public static class HelloForm {

        private String name;

        public String getName() { return name; }

        public void setName(final String name) { this.name = name; }
    }
}