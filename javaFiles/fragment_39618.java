@SpringBootApplication
public class DemoApplication {

    @Autowired
    private UserService userService; //handles user saving


    @Profile("dev")
    @Bean
    public ApplicationRunner devApplicationRunner(){
        return arg->{
           User user = new User();
           user.setName("Dummy User");
           userService.save(user);
        };
    }

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }
}