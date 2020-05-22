public class AngryBirdGame {
    float vo, degree, xo, yo;

    public static void main(String[] args) {
        printOneTimeIntro();
        Scanner in = new Scanner(System.in);
        for (int i = 0, AngryBirdGame game = getGameInfo(in);
                 i < 4 && game != null;
                 i++, game = getGameInfo()) {
            float time = game.play();
            System.out.format("The time it took to get to the ground is %f%n", time);
        }
    }

    /**
     * A static method to print a one-time introduction to the program.
     */
    private static void printOneTimeIntro() {
        System.out.println("This game is the Angry Bird Game. You will be trying to hit the target.");
    }

    /**
     * A static method to check whether the user wants to play and, if so,
     * to collect all the game info.
     *
     * @return a game object, or {@code null} if the user no longer wants to play.
     */
    private static AngryBirdGame getGameInfo(Scanner in) {
        // first check if the user wants to play
        System.out.println("Do you want to play (y/n)? ");
        String input = in.next();
        if (input.toLowerCase().startsWith("n")) {
            return null;
        }

        // if so, create a game object and get all the input
        AngryBirdGame game = new AngryBirdGame();
        System.out.println("One of the targets of the game is (500,0)");
        System.out.println("The other target of the game is (1000,0)");
        System.out.println("Please enter the initial velocity");
        game.v0 = in.nextFloat();
        // TODO: get rest of input

        return game;
    }

    /**
     * An instance method that plays the game once everything is initialized.
     *
     * @return the time it takes for the trajectory to complete
     */
    private float play() {
        float time;

        // TODO: calculate the game time to reach the ground

        return time;
    }
}