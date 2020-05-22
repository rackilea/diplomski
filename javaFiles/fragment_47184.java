import java.util.*;
import java.io.*;
class delimiter {
    public static void main(String[] args) {
Scanner input = new Scanner(System.in);
    System.out.println("Enter the first rational number seperated by '/':");
    String[] parts = input.nextLine().split("/");
    int numerator1 = Integer.parseInt(parts[0]);
    int denominator1 = Integer.parseInt(parts[1]);


    System.out.println(numerator1 + " " + denominator1);
}
}