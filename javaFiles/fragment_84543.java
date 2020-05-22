public enum Hand {
    ROCK,
    PAPER,
    SCISSORS;

    private Hand beats;

    static {
        ROCK.beats = SCISSORS;
        PAPER.beats = ROCK;
        SCISSORS.beats = PAPER;
    }

    public Hand getBeats() {
        return beats;
    }

    public static void main(String[] args) {
        for (Hand hand : Hand.values()) {
            System.out.printf("%s beats %s%n", hand, hand.getBeats());
        }
    }
}