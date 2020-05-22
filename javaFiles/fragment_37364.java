@EnableCaching
@SpringBootConfiguration
@EnableAutoConfiguration
@ComponentScan(lazyInit = true) 
@EnableAsync(mode = AdviceMode.ASPECTJ) // Changes here!!!
public class Main {
    public static void main(String[] args) {
        new SpringApplicationBuilder().sources(Main.class)
                                    .run(args);
    }
}