@Configuration
@EnableBatchProcessing
@ComponentScan({"abc.","com.abc"})
@Import({Project1Config.class})
public class Project2Configuration {
}