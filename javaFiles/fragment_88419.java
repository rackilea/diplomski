@SpringBootApplication
public class UserServiceApplication {

    @Autowired
    private JwtFilter jwtFilter;

    @Bean
    public FilterRegistrationBean jwtFilter() {
        FilterRegistrationBean registrationBean = new FilterRegistrationBean();
        registrationBean.setFilter(jwtFilter);
        ...
    }
    ...