@SpringBootApplication
public class MyApplication extends RepositoryRestConfigurerAdapter{
    public static void main(String[] args) {
        SpringApplication.run(MyApplication.class, args);
    }

    @Override
    public void configureValidatingRepositoryEventListener(ValidatingRepositoryEventListener validatingListener) {
        validatingListener.addValidator("beforeCreate", new MyModelValidator());
        validatingListener.addValidator("beforeSave", new MyModelValidator());
    }
}