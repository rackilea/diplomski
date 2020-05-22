public class MyCustomValidator implements ConstraintValidator<ValidData, String> {

  @Override
  public boolean isValid(String data, ConstraintValidatorContext context) {
    //my custom logic regarding recoverData.getData()
    return true;
  }

}