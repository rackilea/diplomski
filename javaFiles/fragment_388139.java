public static void gameModeSelect() {
    System.out.println("Welcome to Rock, Paper, Scissors 1.0 !\n Please select your game mode: ");
    System.out.println("1. Player vs. Computer\n 2. Player vs. Player ");
}

public static void winLoss(char P1, char P2) {

    if (P1 == 'P' && P2 == 'R') {
        System.out.println("Paper covers rock!\nPlayer one wins!");
    } else if (P1 == 'R' && P2 == 'P') {
        System.out.println("Paper covers rock!\nPlayer two wins!");
    }
    if (P1 == 'R' && P2 == 'S') {
        System.out.println("Rock breaks scissors!\nPlayer one wins!");
    } else if (P1 == 'S' && P2 == 'R') {
        System.out.println("Rock breaks scissors!\nPlayer two wins!");
    }
    if (P1 == 'S' && P2 == 'P') {
        System.out.println("Scissor cuts paper!\nPlayer one wins!");
    } else if (P1 == 'P' && P2 == 'S') {
        System.out.println("Scissor cuts paper!\nPlayer two wins!");
    }
}

public static void main(String[] args) {
    Scanner keyboard = new Scanner(System.in);

    char P1;
    char P2;
    int modeSelect;

    gameModeSelect();
    modeSelect = keyboard.nextInt();

    if (modeSelect == 1) {
        System.out.println("Oops, this feature in currently unavailable. Play with a friend for now :-)");
    } else if (modeSelect == 2) {

        System.out.println("Rules of the game:  R = Rock, P = Paper, S = Scissors\n Good luck! ");

        System.out.println("Player one: Enter your move");
        P1 = keyboard.next().charAt(0);
        System.out.println("Player two: Enter your move");
        P2 = keyboard.next().charAt(0);
        winLoss(P1, P2);

    }
}