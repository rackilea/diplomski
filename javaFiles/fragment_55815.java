int max_players = 0;
Scanner input = new Scanner(System.in);
while (true) {
    System.out.println("How many players are going to play the game?");
    try {
        max_players = input.nextInt();
        break;
    } catch (InputMismatchException ee) {
        System.out.println("try again");
        input.nextLine ();
    }
}