import java.util.*;

class FahrenheitToCelsiusBothInput {

public static void main(String[] args) {
float Fahrenheit = 32;
float Celsius = 0;

Scanner option = new Scanner(System.in);

System.out.println("Do You Want to Enter Fahrenheit or Celsius: ");
int userInput = option.nextInt();

switch(userInput) {                      //Getting "Syntax error on token "{", SwitchLabels expected after this token"
case 0:
        System.out.println("Enter temperature in Fahrenheit: ");
        Fahrenheit = option.nextInt();
        Fahrenheit = (float) ((Fahrenheit - 32) / 1.8000);
        System.out.println("Temperature in Celsius = " + Fahrenheit);  System.out.println("Thank You! ");
   break; 
case 1:
        System.out.println("Enter temperature in Celsius: ");
        Celsius = option.nextFloat();
        Celsius = (float) ((Celsius * 1.8000) + 32);
        System.out.println("Temperature in Fahrenheit = " + Celsius);  System.out.println("Thank You! ");
    break;  
default:
        System.out.println("Something went wrong! ");
    break;
        }
    }
}