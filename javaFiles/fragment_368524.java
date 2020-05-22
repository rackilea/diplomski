import java.util.Scanner;
public class Test {

  private static Scanner scanner;

  public static void main(String[] args) {
    // TODO Auto-generated method stub
    String answer;
    scanner = new Scanner(System.in);
    System.out.println("Hello Human");
    System.out.println("Do you want to build a snowman?");
    answer = scanner.next();
    if (answer.equalsIgnoreCase("Yes")) {
      System.out.println("Yay, Now you must think hard of what Olaf Looks like Okay? (say okay to coninue)");
    }
    else {
      System.out.println("Go away! I hate you"); //This happens when I try to say Yes.. This is meant for no.
    }
  }
}