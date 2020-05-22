public class nameEntry {
  private static final Pattern VALID_NUMBER = Pattern.compile("\\d{4}");
  private String surname;
  private String number;

  public nameEntry(String surname, String number) {
    this.surname = surname;
    if(!VALID_NUMBER.matcher(number).matches()) {
      throw new IllegalArgumentException(number+
                " does not appear to be a valid phone number.");
    }
    this.number = number;
  }

  @Override
  public String toString() {
    return surname + "\t" + number; //eg HOOD     0123
  }
}