@SpringBootApplication
public class SpringMvcApplication {

    private static ApplicationContext context;

    public static void main(String[] args) {
        context = SpringApplication.run(SpringMvcApplication.class, args);
    }

    public static JdbcTemplate getJdbcTemplate() {
        return context.getBean(JdbcTemplate.class);
    }

}