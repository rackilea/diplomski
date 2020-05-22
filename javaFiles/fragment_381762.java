public class PasswordValidator {

  private static final int MAX_LENGTH = 20;
  private static final String PASSWORD_PATTERN = String.format(
      "((?=(.*\\d){2})[a-zA-Z0-9]{8,%d})", MAX_LENGTH);

  private Pattern pattern;
  private Matcher matcher;

  public PasswordValidator() {
    pattern = Pattern.compile(PASSWORD_PATTERN);
  }

  public boolean validate(final String password) {
    matcher = pattern.matcher(password);
    return matcher.matches();
  }

  public static void main(String[] args) {
    PasswordValidator pv = new PasswordValidator();
    System.out.println(pv.validate("Abjh23af")); // pass
    System.out.println(pv.validate("879789765")); // pass
    System.out.println(pv.validate("legoF111")); // pass
    System.out.println(pv.validate("Danrad1d")); // fail
    System.out.println(pv.validate("FFJURi22@")); // fail
    System.out.println(pv.validate("aj22b34")); // fail
    System.out.println(pv.validate("1abcdef2")); // pass (thanks to extra parenthesis)
  }
}