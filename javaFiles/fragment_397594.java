@Component
public class AppValidator implements Validator<String> {
  @Override
  public boolean validate(String data) {
    return ...;
  }
}