public class ValidateListValidator implements ConstraintValidator<ValidateList, List<Object>> {

private ValidateList validateList;
@Override
public void initialize(ValidateList validateList) {
    this.validateList = validateList;
}

@Override
public boolean isValid( List<Object> list, ConstraintValidatorContext constraintValidatorContext) {
    return list.stream().noneMatch(Objects::isNull);
  }

 }