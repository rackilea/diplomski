import java.util.*;

class calc {
    public static void main(String ar[]) {
        char choice;
        Scanner in = new Scanner(System.in);
        System.out.println("WELCOME TO SHREYDAN'S CALC 1.0");
        System.out.println(" ");

        boolean loop = true;
        while (loop) {
            System.out.println("YOU CAN DO THE FOLLOWING:");
            System.out.println("+: ADDITION");
            System.out.println("-: SUBTRACTION");
            System.out.println("*: PRODUCT");
            System.out.println("/: QUOTIENT");
            System.out.println("#: SQUARE ROOT");
            System.out.println("^: POWER");
            System.out.println("$: ROUND OFF");
            System.out.println("!: FACTORIAL");
            System.out.println(" ");
            System.out.println("ENTER CHOICE");
            choice = in.next().charAt(0);
            switch (choice) {
                case '+':
                    System.out.println("ENTER 2 NUMBERS, USER");
                    double a = in.nextDouble();
                    double b = in.nextDouble();
                    System.out.println("SUM = " + (a + b));
                    break;
                case '-':
                    System.out.println("ENTER 2 NUMBERS, USER");
                    double c = in.nextDouble();
                    double d = in.nextDouble();
                    System.out.println("SUBTRACTING " + d + " FROM " + c + " ... DIFFERENCE = " + (c - d));
                    break;
                case '*':
                    System.out.println("ENTER 2 NUMBERS, USER");
                    double e = in.nextDouble();
                    double f = in.nextDouble();
                    System.out.println("PRODUCT = " + (e * f));
                    break;
                case '/':
                    System.out.println("ENTER 2 NUMBERS, USER");
                    double g = in.nextDouble();
                    double h = in.nextDouble();
                    System.out.println("DIVIDING " + g + " BY " + h + " = " + (g / h));
                    break;
                case '#':
                    System.out.println("ENTER NO. FOR SQAURE ROOT:");
                    double sqrt = in.nextDouble();
                    System.out.println("SQUARE ROOT OF " + sqrt + " = " + Math.sqrt(sqrt));
                    break;
                case '^':
                    System.out.println("ENTER BASE, USER");
                    double base = in.nextDouble();
                    System.out.println("ENTER POWER, USER");
                    double power = in.nextDouble();
                    System.out.println(base + " RAISED TO POWER " + power + " = " + Math.pow(base, power));
                    break;
                case '$':
                    System.out.println("ENTER DECIMAL VALUES TO ROUND OFF");
                    double deci = in.nextDouble();
                    System.out.println("THE NEAREST ROUND OFF = " + Math.round(deci));
                    break;
                case '!':
                    System.out.println("ENTER A NO. FOR FACTORIAL:");
                    int fact = in.nextInt();
                    int factorial = 1;
                    for (int i = fact; i >= 1; i--)
                        factorial = factorial * i;
                    System.out.println(fact + "! = " + factorial);
                    break;
                default:
                    System.out.println("WRONG CHOICE USER");
            }
            System.out.println("Want to calculate more?Y/N");
            loop = in.next().charAt(0) == 'Y';
        }
    }
}