@Aspect
public class ValidationAdvice {
    @Autowired
    private ValidatorDefault validatorDefault;

    public void validate(JoinPoint jp) throws Throwable {
        validatorDefault.validate(jp);
    }
}

@Component
public class ValidatorDefault {
    @Autowired
    ValidationService validationService

    public void validate(JoinPoint jp) throws Throwable {
        //Calls the validationService to validate the parameters
    }
}