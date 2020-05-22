import org.springframework.context.annotation.*;

@EnableAspectJAutoProxy
@EnableWebMvc
@ComponentScan(basePackages="main.java")
@Import({WebConfiguration.class, ApplicationContextConfiguration.class })
public class AppConfig implements WebMvcConfigurer {
//Your current configuration
}