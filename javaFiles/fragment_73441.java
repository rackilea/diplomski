@Configuration
@EnableJpaRepositories(basePackages = {"com.repository"}
public class MyConfiguration {
    // possibly your Bean declarations here
    // like dataSource, transactionManager etc.. related to your jpa repo
    // as needed
}