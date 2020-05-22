public class ReportConstraintValidator implements ConstraintValidator<ValidReport, Report> {

@Autowired
DesignRepository designRepository;

@Override
public void initialize(ValidReport constraintAnnotation) {
}

@Override
public boolean isValid(Report report, ConstraintValidatorContext context) {
    ...
    context.buildConstraintViolationWithTemplate("foo error message").addConstraintViolation();
    return false;
    ...
    context.buildConstraintViolationWithTemplate("foo error message").addConstraintViolation();
    return false;
}
}