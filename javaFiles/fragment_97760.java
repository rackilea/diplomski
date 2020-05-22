import java.util.Scanner;

    public class OddsAndEvens {
        public static void main(String[] args) {
            Scanner input = new Scanner(System.in);
            System.out.println("Let’s play a game called “Odds and Evens”");
            System.out.println("What is your name?");
            String name = input.next();
            while(true) {
            // 1 <------------------------

            System.out.println("Hello " + name + " which one do you choose? (O)dds or (E)vens?"); 

            String oe = input.next();

            if (oe.equalsIgnoreCase("e")) {
                System.out.println(name + " has picked evens! The computer will be odds.");
                //do even logic here
                break;
            }
            if (oe.equalsIgnoreCase("o")) {
                System.out.println(name + " has picked odds! The computer will be evens.");
                //do odd logic here
                break;
            }

            else {
                System.out.println("You have typed an invalid answer, lets try again");

            }
        }


        }

    }