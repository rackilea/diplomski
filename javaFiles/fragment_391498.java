public static void main(String[] args) {

    char userChar = 0;

    Scanner sc = new Scanner(System.in);
    Random rnd = new Random();

    // Intro/directions/prompting for user input
    System.out.println("Welcome to Rock, Paper, Scissors by Rancid!");
    System.out.println("Choose R for Rock, P for Paper, S for Scissors, or Q to Quit, then press Enter: ");

    // Start of loop
    while (true) {
        // what I changed
        // **********************************************************
        String line = sc.nextLine().toLowerCase();
        if(line.equals("q")){
            System.out.println("Player chose to quit. Goodbye!");
            break;
        }
        if(!line.equals("r") && !line.equals("s") && !line.equals("p")) {
            System.out.println("Invalid input! Please enter a valid character.");
            continue;
        }
        userChar = line.charAt(0);
        // **********************************************************

        // Prompting computer to generate a random number
        int randomNumber = rnd.nextInt(3) + 1;

        // If computer generates 1 (Rock)
        if (randomNumber == 1) {
            if (userChar == 'r' || userChar == 'R') {
                System.out.println("Rock vs. Rock! It's a tie!");
            } else if (userChar == 'p' || userChar == 'P') {
                System.out.println("Paper covers Rock, you win!");
            } else if (userChar == 's' || userChar == 'S') {
                System.out.println("Rock breaks Scissors, you lose!");
            }
        }

        // If computer generates 2 (Paper)
        else if (randomNumber == 2) {
            if (userChar == 'r' || userChar == 'R') {
                System.out.println("Paper covers Rock, you lose!");
            } else if (userChar == 'p' || userChar == 'P') {
                System.out.println("Paper vs. Paper! It's a tie!");
            } else if (userChar == 's' || userChar == 'S') {
                System.out.println("Scissors cuts Paper, you win!");
            }
        }

        // If computer generates 3 (Scissors)
        else if (randomNumber == 3) {
            if (userChar == 'r' || userChar == 'R') {
                System.out.println("Rock breaks Scissors, you win!");
            } else if (userChar == 'p' || userChar == 'P') {
                System.out.println("Scissors cuts Paper, you lose!");
            } else if (userChar == 's' || userChar == 'S') {
                System.out.println("Scissors vs. Scissors! It's a tie!");
            }
        }
    }
}