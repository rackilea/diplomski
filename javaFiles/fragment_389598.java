@SpringBootApplication
public class CamelApplication extends FatJarRouter {

    public static void main(String... args) {
        ApplicationContext applicationContext = SpringApplication.run(DemoApplication.class, args);
        CamelSpringBootApplicationController applicationController =
                applicationContext.getBean(CamelSpringBootApplicationController.class);
        applicationController.run();
    }

    @Override
    public void configure() throws Exception {
        from("file:input?noop=true")
                .log("Read from the input file")
                .to("file:destination")
                .log("Written to output file");
    }
}