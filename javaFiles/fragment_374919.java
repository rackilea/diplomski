public class Game{
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int points = 0;
        int multiply;
        System.out.println("press e to exit the game at any time!");
        System.out.println("please enter a number");
        int yourNumber = input.nextInt();

        for (multiply = 0; multiply<= 10; multiply++){
            int yourAnswer = yourNumber * multiply;

            System.out.println(yourNumber + " x " + multiply + " = ? ");

            //new part:
            String nextIn = input.next();
            int theAnswer = 0;
            if (nextIn.equals("e")) {
                System.out.println("Exiting the game...")
                break;
            } else {
                theAnswer = Integer.parseInt(nextIn);
            }

            for (int tries = 1; tries<= 4; tries++){

                if (theAnswer == yourAnswer){

                    points = points + 5;
                    System.out.println("you have " + points + " points");
                    break;
                }
                else{
                    System.out.println("Your answer : " + theAnswer  + " is wrong, please try again. Attempts : " + tries + " out of 4");
                    theAnswer = input.nextInt();

                    points--;

                    if (tries == 4){
                        System.out.println("sorry maximum attempts!!! moving to the next question");
                        tries++;
                        break;

                    }

                }
            }
        }

    }
}