import java.util.Random;
import java.util.Scanner;

public class MathProblems {
     private static final int MAX_NUMBER = 10;
     private static final Random random = new Random();

     private int expected = 0;
     private String question = "";

     public void run() {
         final int a = random.nextInt(MAX_NUMBER);
         final int b = random.nextInt(MAX_NUMBER);

         final int type = random.nextInt(4);

         switch (type) {
             case 0: 
                 add(a, b);
                 break;
             case 1: 
                subtract(a, b);
                break;
             case 2:
                multiply(a, b);
                break;
             case 3:
                 divide(a, b);
                 break;
         }
     }

     private void add(final int a, final int b) {
         expected = a + b;

         askQuestion(a + " + " + b + "=");
     }

     private void subtract(final int a, final int b) {
         expected = a - b;

         askQuestion(a + " - " + b + "=");
     }

     private void multiply(final int a, final int b) {
         expected = a * b;

         askQuestion(a + " * " + b + "=");
     }

     private void divide(final int a, final int b) {
         expected = a / b;

         askQuestion(a + " / " + b + "=");
     }

     private int askQuestion(final String question) {
         this.question = question;
     }  

     public String getQuestion() {
         return question;
     }

     public String checkResult(final int answer) {
         if (expected == answer) {
            return "Correct answer! You rock!";
         } else {
            return "WROOONG! You suck!";
         }    
     } 

}