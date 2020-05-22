import java.util.Scanner;

public class howToDoRepeatedSequanceCheck {

  public void repeatedTests() {

      String whole;
      int inputLength,i;

      Scanner keyboard = new Scanner(System.in);
      System.out.println("Enter an input string:");
      whole = keyboard.nextLine();

      while(!whole.equals("quit")) {

        whole=whole.replaceAll("\\s+","");
        inputLength = whole.length();
        boolean isInOrder = true;
        i = 0;
        while(isInOrder && i<inputLength-1 ) {
          if(whole.charAt(i)<whole.charAt(i+1)) {
//            System.out.println("ok " + whole.charAt(i)+ " < " +whole.charAt(i+1));
          }else {
//            System.out.println("error");
            isInOrder = false;
          }
          i++;
        }

        if(isInOrder == true) {
          System.out.println("The input is in order");
        }else {
          System.out.println("The input is out of order");
        }
        System.out.println();

        System.out.println("Enter an input string:");
        whole = keyboard.nextLine();
      }
      System.out.println("Goodbye");

  }

}