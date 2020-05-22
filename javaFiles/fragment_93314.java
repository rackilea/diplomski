import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Calculator {

    public static void main(String[] args) {

        System.out.println("Hello, welcome to my calculator");
        System.out.println("Enter in some stuff you want to me to calculate");

        Scanner scan = new Scanner(System.in);
        System.out.println("If you need help please type \"help\"");
        System.out.println("If at anytime you want to leave, type \"quit\"");
        System.out.println("Hit enter to continue.");

        String s1 = scan.nextLine();

        if (s1.equals("help")) {
            System.out.println(" ");

            System.out.println("Double operand commands:");
            System.out.println("Addition: '+' (Ex: 'a + b' )");
            System.out.println("Subtraction: '-' (Ex: 'a - b' )");
            System.out.println("Multiplication: '*' (Ex: 'a * b' ) ");
            System.out.println("Division: '/' (Ex: 'a / b' )");
            System.out.println("Exponents: '^' (Ex: 'a ^ b' )");

            System.out.println(" ");
        } else if (s1.equals("quit")) {
            System.out.println("Thank you for using my program!");
            System.exit(0);
        }

        Scanner input = new Scanner(System.in);


        Maths maths = new Maths();

        double answer = 0;
        double numA=0.0, numB=0.0;
        char operator;
        boolean quit = false;

        while (true) {

            System.out.print("Please enter your equation: ");

            //First scan the function as a string
            String s = input.next();

            if (s.equals("quit")) {
                System.out.println("Thank you for using my program!");
                System.exit(0);
            }

          //We will use regex to find the operator, so we will omit all alphabetic letter or numeric number or decimal
            String operator1 = s.replaceAll("[a-zA-Z0-9.]",""); 
          //For functions like -4|, the operator1 will be -| after replacing through regex, we will only take the second digit as operator to prevent error
            if(operator1.length()==1) 
            operator = operator1.charAt(0);
            else
                operator = operator1.charAt(1); 
            String[] num11 = (s.split("[^0-9,.]"));
        //String array num11 may contain null string after splitting using regex, we will remove those null string and store only variable values in an arraylist
           ArrayList<String> arraylist = new ArrayList<String>();

            for (int i = 0; i < num11.length; i++)
            {
                if (!num11[i].equals(""))
                {
                    arraylist.add(num11[i]);
                }
            }



            if(arraylist.size()==1){
            numA = Double.parseDouble(arraylist.get(0));    
            numB=numA;}
            else if(arraylist.size()==2){
            numA = Double.parseDouble(arraylist.get(0));    
            numB = Double.parseDouble(arraylist.get(1));

            }




            if (operator == '+') {
                answer = maths.add(numA, numB);
            }

            if (operator == '-') {
                answer = maths.subtract(numA, numB);
            }

            if (operator == '*') {
                answer = maths.multiply(numA, numB);
            }

            if (operator == '/') {
                answer = maths.divide(numA, numB);
            }

            if (operator == '^') {
                answer = maths.power(numA, numB);
            }

            if (operator == '|') {
                answer = Math.abs(numA);
            }

            System.out.println(answer);

        }

    }

    public static class Maths {

        public void Maths(){};

        double add(double a, double b) {
            double answer = a + b;
            return answer;
        }

        double subtract(double a, double b) {
            double answer = a - b;
            return answer;
        }

        double multiply(double a, double b) {
            double answer = a * b;
            return answer;
        }

        double divide(double a, double b) {
            double answer = a / b;
            return answer;
        }

        double power(double a, double b) {
            double answer = a;

            for (int x = 2; x <= b; x++) {
                answer *= a;
            }

            return answer;
        }

        double absolute(double a) {
            double answer = Math.abs(a);
            return answer;
        }

    }

}