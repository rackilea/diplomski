@SpringBootApplication
public class StrangerApplication {

    public static void main(String... args) throws Exception {
        SpringApplication.run(StrangerApplication.class, args);
    }

    @Bean (name="sessionFactory")
    public SessionFactory configureSessionFactory(EntityManagerFactoryBean emf) {
        SessionFactory sessionFactory = emf.unwrap(SessionFactory.class);
        return sessionFactory;
    }

}