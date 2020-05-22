public class YourClass {
  public static void main(String[] args) {
    //variable declaration
    char letter;
    letter = getLetter();
    System.out.println(letter);
  }

  public static char getLetter() {
    String text;
    char letter;

    text = JOptionPane.showInputDialog("Enter a letter.");
    letter = text.charAt(0);

  System.out.println(letter);
  return letter;
  }
}