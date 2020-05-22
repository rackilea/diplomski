import java.util.Scanner;

class Main {

  public static void main(String[] args) {
    int userInteger = getIntegerInput();
    System.out.println("You entered: " + userInteger);
  }

  private static int getIntegerInput() {
    Scanner scanner = new Scanner(System.in);
    String prompt = "Please enter an integer: ";
    int validInteger = -1;

    System.out.print(prompt);
    while (scanner.hasNext()) {
      if (scanner.hasNextInt()) {
        validInteger = scanner.nextInt();
        scanner.close();
        break;
      } else {
        System.out.println("Error: Invalid input");
        System.out.print(prompt);
        scanner.next();
      }
    }

    return validInteger;
  }

}