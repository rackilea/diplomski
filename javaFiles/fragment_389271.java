@Component
public class SomethingParamsValidator implements Validator {
  @Override
  public boolean supports(Class<?> clazz) {
    return clazz.isAssignableFrom(SomethingParams.class);
  }

  @Override
  public void validate(Object o, Errors errors) {
    SomethingParams sp = (SomethingParams)o;
    validateToken(sp.getToken(), errors);
  }

  private void validateToken(String token, Errors errors) {
    if (!TokenUtils.isValid(token)) {
      errors.rejectValue("token", "foo", "Token is invalid");
    }
  }
}