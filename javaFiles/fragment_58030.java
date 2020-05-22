public class TurnBasedGame {
    public enum State {
        READY,
        RUNNING,
        ENDED
    }

    private final List<Player> players = new ArrayList<>();
    private final int rounds;
    private int currentRound;
    private int currentTurn;
    private State currentState = State.READY;


    public TurnBasedGame() {
        this(1);
    }

    public TurnBasedGame(int rounds) {
        this.rounds = rounds;
    }

    public void addPlayer(Player player) {
        players.add(player);
    }

    public List<Player> getPlayers() {
        return players;
    }

    public void start() {
        currentTurn = 0;
        currentRound = 0;
        currentState = State.RUNNING;
    }

    public void endPlayerTurn() {
        if (currentState != State.RUNNING) {
            throw new IllegalStateException("Game is not started");
        }

        currentTurn++;

        if (currentTurn >= players.size()) {
            currentTurn = 0;
            currentRound = 0;
        }
        if (currentRound >= rounds) {
            currentState = State.ENDED;
        }
    }

    public State getCurrentState() {
        return currentState;
    }

    public Player getCurrentPlayer() {
        return players.get(currentTurn);
    }
}