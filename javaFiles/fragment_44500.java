@SpringBootApplication
@ComponentScan("com.foo.project")
public class MainApplication extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(MainApplication.class);
    }

    public static void main(String[] args) {
        new MainApplication().configure(new SpringApplicationBuilder(MainApplication.class)).run(args);
    }
}