import java.util.Scanner;

public class MaximiseSum {
    public static void main(String args[]) {
        int numberofsquarefeet = 900;
        int result=gallonsofpaint(numberofsquarefeet,115,1);
        System.out.println("the number of gallons of paint required is " + result);

        int resultnumberofhours = hoursoflabor(numberofsquarefeet,115,8);
        System.out.println("the number of hours needed are " + resultnumberofhours);
    }
    public static int gallonsofpaint(int numberofsquarefeet, int squarefeet, int paint) {
        int result = numberofsquarefeet / 115 * 1;
        return result;
    }

    public static int hoursoflabor(int numberofsquarefeet, int squarefeet, int labor) {
        int resultnumberofhours = (int) ((numberofsquarefeet * 8 ) / 115);
        return resultnumberofhours;
    }
}