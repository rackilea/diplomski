import java.util.*;

public class Sec {

  public static void main(String[] args) {
    Scanner secnum = new Scanner(System.in);
    System.out.println("Give Sec: ");
    String sec = secnum.nextLine();

    while (sec.length() != 9) {
      System.out.println("Wrong lenght Sec,enter again");
      secnum.nextLine();
    }

    System.out.println("Sec lenght okay");
  }
}