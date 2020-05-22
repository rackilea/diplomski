@SpringBootApplication
public class So45616063Application {

    public static void main(String[] args) {
        SpringApplication.run(So45616063Application.class, args);
    }

    public static class PersonForm {
        private String firstname;
        @NotBlank
        private String lastname;

        public void setFirstname(String firstname) {
            this.firstname = firstname;
        }

        public void setLastname(String lastname) {
            this.lastname = lastname;
        }

        @Override
        public String toString() {
            return firstname + " " + lastname;
        }
    }

    @RestController
    @RequestMapping("/")
    public static class Home {

        @GetMapping
        public void get(@Valid PersonForm form, BindingResult bindingResult) {
            System.out.println(form);
            System.out.println(bindingResult);
        }
    }
}