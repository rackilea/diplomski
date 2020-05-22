public class Test {
  public static void main(String[] args) {
    for (int i = Character.MIN_CODE_POINT;
         i <= Character.MAX_CODE_POINT;
         i++) {
      if (Character.isLetter(i) &&
          !Character.isUpperCase(i) &&
          !Character.isLowerCase(i)) {
        System.out.printf("%04x %c%n", i, i);
      }
    }
  }
}