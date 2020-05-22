package testdemo;

    import org.springframework.boot.SpringApplication;
    import org.springframework.boot.autoconfigure.SpringBootApplication;
    import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

    @SpringBootApplication
    @EnableJpaRepositories("put repository path here")
    public class TestDemoApplication {

        public static void main(String[] args) {
            SpringApplication.run(TestDemoApplication.class, args);
        }
    }