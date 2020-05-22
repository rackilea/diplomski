public class HumanPlayer implements Player {
    String name;
    public HumanPlayer(String name) {
        this.name=name;
    }
    public String getUserInput(Board board) {
        // your code to ask a move from the user input (System.in.)
    }
}

public class RobotPlayer implements Player {
    String name;
    public RobotPlayer(String name) {
        this.name=name;
    }
    public String getUserInput(Board board) {
        // random answer calculated by some AI logic
    }
}