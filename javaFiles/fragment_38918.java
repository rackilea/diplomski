@Configuration
@EnableAutoConfiguration
@ComponentScan
public class Application {
     public static void main(String[] args) {
            ApplicationContext ctx = SpringApplication.run(Application.class, args);

            System.out.println("NinjaSquare server up and running with Spring Boot!");
            System.out.println("Let's inspect the beans provided by Spring Boot:");

            String[] beanNames = ctx.getBeanDefinitionNames();
            Arrays.sort(beanNames);
            for (String beanName : beanNames) {
                System.out.println(beanName);
            }
        }
}