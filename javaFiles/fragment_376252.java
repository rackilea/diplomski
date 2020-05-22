@SpringBootApplication
@EnableJpaRepositories(basePackages = {"org.test.app", "org.test.lib"})
@ComponentScan(basePackages = {"org.test.app", "org.test.lib"})
public class Application {
  // ...
}