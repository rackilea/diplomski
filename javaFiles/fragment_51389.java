import java.util.*;
public class HelloWorld {

public static void main(String[] args) {

      String morseCode [] = {".- ", "-... ", "-.-. ", "-.. ", ". ", "..-. ", "--. ", ".... ", ".. ", ".--- ", "-.- ", ".-.. ", "-- ", "-. ", "--- ", ".--. ", "--.- ", ".-. ", "... ", "- ", "..- ", "...- ", ".-- ", "-..- ", "-.-- ", "--.. ", "| "};

       //Took user input and converted it into LowerCase Character Array
       Scanner sc = new Scanner(System.in);
       String input = sc.nextLine();
       char[] translate = (input.toLowerCase()).toCharArray();

       //Translating user input(translate[]) using for loop
       for (int j = 0; j < translate.length; j++) {
            System.out.print(morseCode[translate[j] - (int)'a']);
       }
}
}