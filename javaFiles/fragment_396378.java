@SpringBootApplication
@ComponentScan(basePackages = { "com.springdata" })
@EnableMongoRepositories(basePackages={"com.springdata.dao.mongo"})
public class SpringbootmysqlmongoApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootmysqlmongoApplication.class, args);
    }
}