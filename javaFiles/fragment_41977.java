import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;

import ro.scorpionsoftware.demo3.dao.AbstractValidator;


@Component(value="doctorValidator")
public class DoctorValidator extends AbstractValidator {

    @Override
    protected void addExtraValidation(Object objectForm, Errors errors) {
        //perform typical validation
        //can autowire to context
    }


}