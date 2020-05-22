@SpringBootApplication
@RestController
@EnableWebMvc
public class ShowCase {

    public static void main(String[] args) {
        SpringApplication.run(ShowCase.class, args);
    }

    @RequestMapping(value = "submit", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public void getFormKeys(@RequestBody MultiValueMap<String, Object> formData) {
        System.out.println(formData.keySet().stream().collect(Collectors.joining(",")));
    }

}