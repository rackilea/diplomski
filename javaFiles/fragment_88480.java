@Configuration
public class RepoRestConfig extends RepositoryRestConfigurerAdapter {

    private final LocalValidatorFactoryBean beanValidator;

    public RepoRestConfig(LocalValidatorFactoryBean beanValidator) {
        this.beanValidator = beanValidator;
    }

    @Override
    public void configureValidatingRepositoryEventListener(ValidatingRepositoryEventListener v) {
        v.addValidator("beforeCreate", beanValidator);
        v.addValidator("beforeSave", beanValidator);
        super.configureValidatingRepositoryEventListener(v);
    }
}