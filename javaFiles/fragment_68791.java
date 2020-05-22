public class DigitReplace {
  public static void main(String... args) {
    System.out.println(convertString("4 score and 7 years ago"));
    System.out.println(convertString("3 days ago I ate 173 cheeseburgers"));
  }

  public static String convertString(String input) {
    StringBuilder output = new StringBuilder(input.length() * 2);

    boolean foundOne = false;

    // for every character
    for(char c : input.toCharArray()) {
      // if it's a digit
      if (Character.isDigit(c)) {
        // if this is not the first digit, put a dash
        if (foundOne) {
          output.append('-');
        }

        NumberEnum thisWord = NumberEnum.getFromDigit(c - '0');
        output.append(thisWord.getText()); // 

        foundOne = true;
      } else {
        // just add the character
        foundOne = false;
        output.append(c);
      }
    }

    return output.toString();
  }
}