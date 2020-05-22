public class LabExer5A {
    public static void main(String[] args) {
        int max = 50;
        int min = 1;

        int secretNumber;
        secretNumber = (int)(Math.random() * 49 + 1);

        Scanner keyboard = new Scanner(System.in);
        // you should initiate the value. If there is no exception, it would be replaced by the value read from console.
        int guess = Integer.MAX_VALUE;
        int count = 0;

            do{
                System.out.println("Guess a number from 1 to 50");
                try {
                    guess = keyboard.nextInt();
                } catch(InputMismatchException e){
                    System.out.println("Invalid Input");
                    // you should really read the input
                    keyboard.next();
                    count ++;
                    continue;
                }

                count ++;

                if(guess == secretNumber){
                    if(count> 1){
                        System.out.println("You got it in " + count + " attempt(s)");
                    }
                    else{
                        System.out.println("You got it in " + count + " attempt");
                    }
                }
                else if(guess > max){
                    System.out.println("Out of Range");
                }
                else if(guess < min){
                    System.out.println("Out of Range");
                }
                else if(guess > secretNumber){
                    System.out.println("Too High. Try Again");
                }
                else if(guess < secretNumber){
                    System.out.println("Too Low. Try Again");
                }
            }
            while(guess != secretNumber);
        }
}