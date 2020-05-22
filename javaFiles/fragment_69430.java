@Configuration
public class ValidatorConfig {

@Autowired
DefaultApplicationArguments applicationArguments;

@Bean
public ValidatorService validatorService()
{
    String validationId = applicationArguments.getSourceArgs()[0];

    return ExternalValidationAPI.getValidationServiceImp(validationId);
}