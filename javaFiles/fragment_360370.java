@PropertySource("file:target/application-int.properties")
@Configuration
@ComponentScan(basePackages = { "org.adam.rest" })
@EnableWebMvc
public class MySpringWebApplicationContext
        extends AnnotationConfigWebApplicationContext {
}