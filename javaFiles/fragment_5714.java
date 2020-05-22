@SpringBootApplication
@RestController
@EnableResourceServer
public class AuthorizationServiceApplication {

    private final Logger log = LoggerFactory.getLogger(this.getClass());

    @RequestMapping("/user")
    public Principal user(Principal user) {
        log.info("User information display for User: " + user.getName());
        return user;
    }

    @Bean
    UserDetailsService userDetailsService() {
        InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
        manager.createUser(User.withUsername("deniss").password("deniss").roles("USER").build());
        return manager;
    }

    public static void main (String[] args) {
        SpringApplication.run(AuthorizationServiceApplication.class, args);
    }
}