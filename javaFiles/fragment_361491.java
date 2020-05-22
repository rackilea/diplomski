@SpringBootApplication(scanBasePackages = {"com.ibm"})
@EnableJpaRepositories(basePackages = {"com.ibm"})
@EntityScan(basePackages = {"com.ibm"})
public class SBApplication {

  public static void main(String[] args) {
    SpringApplication.run(SBApplication.class, args);
  }
}