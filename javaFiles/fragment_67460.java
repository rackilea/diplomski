import java.util.Scanner;

public class Bar {

  public static void main(String[] args) {
    Scanner keyboard = new Scanner(System.in);
    System.out.print("Please enter name: ");
    String name = keyboard.nextLine();  // local variable
    System.out.print("Please enter value: " );
    int number = keyboard.nextint();  // another local variable
    keyboard.nextLine();  // to handle the end of line characters

    // use local variables in constructor call
    Foo foo = new Foo(name, number);    
}