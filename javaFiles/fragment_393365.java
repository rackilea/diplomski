package temperature;

import java.util.Scanner;

public class Temperature {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        double tempInput = 0, tempF = 0, counter = 0;



        while (tempInput > -100.-0) {
            System.out.println("Please enter in temperature in Centigrade");
            tempInput = scan.nextDouble();
            tempF = (9.0/5.0)*tempInput + 32.0;
            if (tempInput > -100.-0) {
              System.out.print("(F" + tempF + ")");
              System.out.print(" " + "C (" +  tempInput + ")");
              System.out.println("");
            }
        }
    }
}