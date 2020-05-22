package package.name;

import java.util.Scanner;
public class TestingJava
{
  public static void main(String[] args){
    double number;
    Scanner input = new Scanner(System.in);
    System.out.println("Name a number!");
    if(input.hasNextDouble()){
      number = input.nextDouble();
      number = Math.floor(number);
      System.out.println(number);
    } else {
      System.out.println("Expected a double but received " + input.next());
    }
  }
}