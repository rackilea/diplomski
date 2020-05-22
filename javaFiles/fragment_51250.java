public static void main(String[] args) {
    int guess;
    int magic = (int) (Math.random() * 10 + 1);
    // Note that attemps are now initialized as 0
    int attempt1 = 0;
    int attempt2 = 0;
    int attempt3 = 0;
    int attempt4 = 0;
    int attempt5 = 0;
    // Or an int-array for attempts
    int players;

    // Get the amount of players
    do {
        players = Integer.parseInt(JOptionPane.showInputDialog(null, "Enter Number of Players. \n2-5 Only"));
        // Notify user if players < 2 || > 5
    } while (players < 2 || players > 5);

    // Play game for each player
    int player = 0;
    do {
        // Logic for a single player here, namely:
        // Increase the attempt based on the player, if you
        // know what an int-array is, use this. Always increase the
        // attempt, because a succesfull attempt is still an attempt.
        // Request input
        // Check if the guess equals the magic number
        // Notify the user
        player++;
    } while (player < players);

    // Notify winner based on lowest attempt, but only if attempt > 0.
    // This is why I've initialized attempts as 0.
}