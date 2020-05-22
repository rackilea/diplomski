...
import org.springframework.validation.Validator;
...

@Component
public class ProjectValidator implements Validator {

    @Override
    public boolean supports(Class<?> clazz) {
        return Project.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        Project project = (Project) target;

        /* Do your checks here */
        ...

        if (managerIdDoesNotMatch) {
            errors.rejectValue("manager.id", "your_error_code");
        }

        ...

        if (operatorIdDoesNotMatch) {
            errors.rejectValue("operator.id", "your_error_code");
        }

        ...
    }
}