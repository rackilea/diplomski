public static void main(String[] args) {
        Random rand = new Random();
        int NumberOfAnswers = addOrSubtract.length;
        int pick = rand.nextInt(NumberOfAnswers);       
        choice = addOrSubtract[pick];
        int randomNumber1 = rand.nextInt(10);
        int randomNumber2 = rand.nextInt(10);
        if (choice == "+") {
            answer = randomNumber1 + randomNumber2; 
        } else {
            answer = randomNumber1 - randomNumber2; 
        }
        System.out.println(randomNumber1 + " " + choice + " " + randomNumber2 + " = ");
        Scanner input = new Scanner(System.in);
        int inputAnswer = input.nextInt();
        if (inputAnswer == answer) {
            System.out.println("Correct! The answer was: " + answer);
            main(null);
        } else {
            System.out.println("Incorrect. The answer was: " + answer);
            System.out.println("Good-Bye!");
            System.exit(0);
        }
        input.close();
 }