import java.util.Scanner;
public class Compare{
  public static void main(String[] args){
    Scanner input = new Scanner(System.in);
    System.out.println("Enter a NAME");
    String name = input.nextLine();
    if(name.equals("Henry"))
      System.out.println("Welcome Henry");
    else
      System.out.println("Invalid Input");
  }
}