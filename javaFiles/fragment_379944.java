@ComponentScan(basePackages = {"foo.bar"})
@SpringBootApplication
@EnableJpaAuditing
@EnableJpaRepositories("your.repository.packagename")
@EntityScan("your.domain.packagename")
public class CrudApplication {
    //code...
}