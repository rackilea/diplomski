import java.util.*; 

public class DiceGame {
   public static Scanner input = new Scanner(System.in);

   public static void main(String[] args) {
      System.out.println("Welcome to the Lab 7 Dice Game.");
      name();
      dice();
   }
   public static String name(){
      System.out.print("What is your name? ");
      String name = input.nextLine();
      return name;
   }
   public static int dice(){
      System.out.print("How many rolls per round? ");
      int dice = input.nextInt();
      input.nextLine();
      return dice;
   }
}