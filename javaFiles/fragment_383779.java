import java.util.Scanner;

public class So{
    public static void main(String args[]) {
        int numberofsquarefeet = 900;
        int result=gallonsofpaint(numberofsquarefeet,115,1);
        System.out.println("the number of gallons of paint required is " + result);

        double resultnumberofhours = hoursoflabor(numberofsquarefeet,115,8);
        System.out.println("the number of hours needed are " + resultnumberofhours);
    }
    public static int gallonsofpaint(int numberofsquarefeet, int squarefeet, int paint) {
        int result = numberofsquarefeet / 115 * 1;
        return result;
    }

    public static double hoursoflabor(int numberofsquarefeet, int squarefeet, int labor) {
        double resultnumberofhours = (double)(numberofsquarefeet * 8 ) / 115;
        return resultnumberofhours;
    }
}