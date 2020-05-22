@EnableAutoConfiguration
@EnableWebMvc
@ComponentScan({"org.app.genesis.client.controller","org.app.genesis.commons.service",
    "org.app.app.commons.security","org.app.genesis.inventory.service","org.app.genesis.client.auth"})
@EnableJpaRepositories(basePackages = "org.app.genesis.*.repo")
@EntityScan(basePackages = "org.app.genesis.*.model")
public class Application extends SpringBootServletInitializer{
  ...
}