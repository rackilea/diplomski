class Player implements Comparable<Player> {
    public final int    score;  // players score
    public final String name;   // players name

    public Player(final int score, final String name) {
        this.score = score;
        this.name = name;
    }
    @Override public int compareTo(final Player other) {
        return other.score - this.score;
        // return this.score - other.score; // or this to reverse order
    }
}

public class PlayerSorting {

    public static void main(final String[] args) {
        try (final Scanner input = new Scanner(System.in);//
                final Scanner input1 = new Scanner(System.in);) {
            System.out.print("Please enter the number of players");
            final int allPlayers = input.nextInt();

            final Player[] playersArray = new Player[allPlayers];
            for (int i = 0; i < allPlayers; i++) {
                System.out.print("What is the name of Player # " + (i + 1) + "?");
                final String name = input1.nextLine();
                System.out.print("What was the score of Player # " + (i + 1) + "?");
                final int score = input.nextInt();
                playersArray[i] = new Player(score, name);
            }

            // sort
            Arrays.sort(playersArray);

            // output all
            System.out.println("SCORES:");
            for (final Player player : playersArray) {
                System.out.println("\t" + player.name + "\t" + player.score);
            }
        }
    }

}