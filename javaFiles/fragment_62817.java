public class Game {
    private List<Player> players;
}

public class Player {
    private Frame[] frames;
} // Since it's more fun to bowl with multiple people

public class Frame {
    private int[numBalls];      // scores per frame
    private int total;

    public int getScore() {};      // total
    public int getBallsThrown() {} // how many balls
    public int getBallsLeft() {};  // how many left
}